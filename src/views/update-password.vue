<template>
  <div :style='{"padding":"0 30px","margin":"0 auto","color":"#666","borderRadius":"4px","background":"none","width":"96%","fontSize":"16px"}'>
    <el-form
	  :style='{"border":"1px solid #dcd6c3","padding":"40px 0 20px","boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","margin":"30px 0 0","borderRadius":"4px","alignItems":"center","flexWrap":"wrap","background":"rgba(255,255,255,.69)","display":"flex","fontSize":"inherit"}'
      class="add-update-preview"
      ref="ruleForm"
      :rules="rules"
      :model="ruleForm"
      label-width="150px"
    >
      <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' label="原密码" prop="password">
        <el-input v-model="ruleForm.password" show-password></el-input>
      </el-form-item>
      <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' label="新密码" prop="newpassword">
        <el-input v-model="ruleForm.newpassword" show-password></el-input>
      </el-form-item>
      <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' label="确认密码" prop="repassword">
        <el-input v-model="ruleForm.repassword" show-password></el-input>
      </el-form-item>
      <el-form-item :style='{"padding":"40px 0","margin":"0","alignItems":"center","textAlign":"center","display":"flex","width":"100%","fontSize":"48px","justifyContent":"center"}'>
		<el-button class="btn3" :style='{"border":"1px solid #eee","cursor":"pointer","padding":"0 20px","margin":"0px 10px","color":"#333","transition":"all 0s","outline":"none","borderRadius":"4px","background":"none","width":"auto","fontSize":"16px","lineHeight":"24px","height":"40px"}' type="primary" @click="onUpdateHandler">
			<span class="icon iconfont icon-tijiao16" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
			提交
		</el-button>
	  </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
	data() {
		return {
			dialogVisible: false,
			ruleForm: {},
			user: {},
			rules: {
				password: [
					{
						required: true,
						message: "密码不能为空",
						trigger: "blur"
					}
				],
				newpassword: [
					{
						required: true,
						message: "新密码不能为空",
						trigger: "blur"
					}
				],
				repassword: [
					{
						required: true,
						message: "确认密码不能为空",
						trigger: "blur"
					}
				]
			}
		};
	},
	mounted() {
		this.$http({
			url: `${this.$storage.get("sessionTable")}/session`,
			method: "get"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.user = data.data;
			} else {
				this.$message.error(data.msg);
			}
		});
	},
	methods: {
		onLogout() {
			this.$storage.remove("Token");
			this.$router.replace({ name: "login" });
		},
		// 修改密码
		async onUpdateHandler() {
			this.$refs["ruleForm"].validate(async valid => {
				if (valid) {
					var password = "";
					if (this.user.mima) {
						password = this.user.mima;
					} else if (this.user.password) {
						password = this.user.password;
					}
					if(this.$storage.get("sessionTable")=='users'){
						if (this.ruleForm.password != password) {
							this.$message.error("原密码错误");
							return;
						}
						if (this.ruleForm.newpassword != this.ruleForm.repassword) {
							this.$message.error("两次密码输入不一致");
							return;
						}
						this.user.password = this.ruleForm.newpassword;
						this.user.mima = this.ruleForm.newpassword;
						this.$http({
							url: `${this.$storage.get("sessionTable")}/update`,
							method: "post",
							data: this.user
						}).then(({ data }) => {
							if (data && data.code === 0) {
								this.$message({
									message: "修改密码成功,下次登录系统生效",
									type: "success",
									duration: 1500,
									onClose: () => {
									}
								});
							} else {
								this.$message.error(data.msg);
							}
						});
						return false
					}
					if (this.ruleForm.password != password) {
						this.$message.error("原密码错误");
						return;
					}
					if (this.ruleForm.newpassword != this.ruleForm.repassword) {
						this.$message.error("两次密码输入不一致");
						return;
					}
					if (this.ruleForm.newpassword == this.ruleForm.password) {
						this.$message.error("新密码与原密码相同");
						return;
					}
					if (this.$storage.get("sessionTable") == 'yonghu') {
						if(this.ruleForm.newpassword && (this.ruleForm.newpassword.length<3)){
							this.$message.error(`新密码长度不能小于3`);
							return
						}
						if(this.ruleForm.newpassword && (this.ruleForm.newpassword.length>10)){
							this.$message.error(`新密码长度不能大于10`);
							return
						}
					}
					if (this.$storage.get("sessionTable") == 'shequyisheng') {
					}
					this.user.password = this.ruleForm.newpassword;
					this.user.mima = this.ruleForm.newpassword;
					this.$http({
						url: `${this.$storage.get("sessionTable")}/update`,
						method: "post",
						data: this.user
					}).then(({ data }) => {
						if (data && data.code === 0) {
							this.$message({
								message: "修改密码成功,下次登录系统生效",
								type: "success",
								duration: 1500,
								onClose: () => {
								}
							});
						} else {
							this.$message.error(data.msg);
						}
					});
				}
			});
		}
	}
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: inherit;
	  	  font-weight: 500;
	  	  display: inline-block;
	  	  width: 150px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #ccc;
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: rgba(255, 255, 255,.6);
	  	  width: auto;
	  	  font-size: 16px;
	  	  min-width: 350px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #ccc;
	  	  border-radius: 0px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: rgba(255, 255, 255,.6);
	  	  width: 200px;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #ccc;
	  	  border-radius: 0px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: rgba(255, 255, 255,.6);
	  	  width: 200px;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #ccc;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: inherit;
	  	  background: rgba(255, 255, 255,.6);
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #ccc;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: inherit;
	  	  background: rgba(255, 255, 255,.6);
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #ccc;
	  	  border-radius: 0px;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: rgba(255, 255, 255,.6);
	  	  width: 500px;
	  	  font-size: 16px;
	  	  height: 140px;
	  	}
	
	.add-update-preview .btn3 {
				border: 1px solid #eee;
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 10px;
				color: #333;
				font-size: 16px;
				line-height: 24px;
				transition: all 0s;
				border-radius: 4px;
				outline: none;
				background: none;
				width: auto;
				height: 40px;
			}
	
	.add-update-preview .btn3:hover {
				border: 1px solid #bda75c;
				transform: skew(0deg, 0deg);
				color: #bda75c;
				background: linear-gradient(180deg, rgba(255,248,216,1) 0%, rgba(231,223,184,1) 100%),#fff;
				opacity: 0.8;
			}
</style>

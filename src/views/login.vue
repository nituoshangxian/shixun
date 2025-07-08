<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(https://bpic.588ku.com/back_pic/05/98/70/025ef5c111a665e.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"flex-start"}'>
      <el-form :style='{"border":"0px solid #eee","minHeight":"850px","padding":"60px 6%  160px","boxShadow":"0 0px 0px rgba(64, 158, 255, .6)","margin":"0 0 0 30%","borderRadius":"0px","textAlign":"center","background":"rgba(255,255,255,1)","width":"750px","fontSize":"16px","height":"auto"}'>
        <div v-if="true" :style='{"padding":"0px","margin":"20px auto 30px","color":"rgba(55,55,55,1)","textAlign":"left","background":"none","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"30px","fontWeight":"500"}' class="title-container">智慧医养大数据公共服务平台医生服务系统</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 auto 60px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="false" class="lable" :style='{"color":"#666","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>用户名：</div>
          <input :style='{"padding":"0 10px","borderColor":"#e6e6e6","color":"#666","borderRadius":"0px","background":"none","borderWidth":"0 0 1px","width":"480px","fontSize":"inherit","borderStyle":"solid","height":"40px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 auto 60px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="false" class="lable" :style='{"color":"#666","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>密码：</div>
          <input :style='{"padding":"0 10px","borderColor":"#e6e6e6","color":"#666","borderRadius":"0px","background":"none","borderWidth":"0 0 1px","width":"480px","fontSize":"inherit","borderStyle":"solid","height":"40px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>

		<div class="list-item select" :style='{"width":"100%","margin":"0 auto 60px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}' v-if="roles.length>1">
			<div v-if="false" class="lable" :style='{"color":"#666","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>角色：</div>
		  <el-select v-model="rulesForm.role" placeholder="请选择角色">
		    <el-option v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" :key="item.roleName" :label="item.roleName" :value="item.roleName" />
		  </el-select>
		</div>

		<div v-if="flag" class="mask" style="position: fixed;z-index: 998;top: 0;right: 0;left: 0;bottom: 0;background: rgba(0,0,0,.5);"></div>
		<!-- option3 -->
		<div v-if="flag" class="box option3" :style='{"padding":"0 24px 24px","transform":"translate3d(-50%,-50%,0)","top":"50%","borderRadius":"20px","left":"50%","background":"#fff","position":"fixed","zIndex":999}'>
			<span @click="flag = !flag" :style='{"cursor":"pointer","padding":"10px","top":"0","fontSize":"20px","position":"absolute","right":"0","zIndex":1}' class="icon iconfont icon-guanbi1 guanbi"></span>
			<div :style='{"lineHeight":"40px","fontSize":"18px","color":"#000","textAlign":"center"}'>身份验证</div>
			<div :style='{"width":"300px","padding":"20px","height":"auto"}' id="option3" class="rotateverify-contaniner">
				<div :style='{"position":"relative"}' class="rotate-can-wrap">
					<canvas width="500" height="500" :style='{"width":"260px","height":"260px"}' class="rotateCan rotate-can"></canvas>
					<span :style='{"padding":"80px","backgroundColor":"rgba(0,0,0,.3)","color":"#fff","display":"none","top":0,"borderRadius":"100%","left":0,"width":"260px","fontSize":"100px","position":"absolute","backgroundPosition":"center center","backgroundRepeat":"no-repeat","height":"260px"}' class="icon iconfont statusBg"></span>
				</div>
				<div :style='{"margin":"10px 0 0","borderRadius":"40px","background":"#f7f7f7","clear":"both","width":"100%","position":"relative","height":"40px"}' class="control-wrap slideDragWrap">
					<div :style='{"width":"100%","position":"relative","height":"100%"}' class="control-tips">
						<p :style='{"overflow":"hidden","whiteSpace":"nowrap","top":0,"color":"#333","textAlign":"center","left":0,"width":"100%","lineHeight":"40px","fontSize":"16px","position":"absolute","textOverflow":"ellipsis","height":"40px"}' class="c-tips-txt cTipsTxt">滑动将图片转正</p>
					</div>
					<div :style='{"border":"1px solid transparent","top":0,"borderRadius":"40px","left":0,"width":"40px","position":"absolute","height":"40px"}' class="control-bor-wrap controlBorWrap"></div>
					<div :style='{"border":"1px solid #e0e0e0","top":0,"borderRadius":"40px","alignItems":"center","color":"#666","left":0,"background":"#fff","display":"flex","width":"40px","position":"absolute","justifyContent":"center","height":"40px"}' class="control-btn slideDragBtn">
						<span :style='{"color":"inherit","fontSize":"18px"}' class="icon iconfont icon-gengduo1"></span>
					</div>
				</div>
			</div>
		</div>
		
        <div :style='{"margin":"60px auto 0","alignItems":"center","flexWrap":"wrap","background":"none","display":"flex","width":"100%","fontSize":"16px","position":"relative","justifyContent":"center"}'>
          <el-button v-if="loginType==1" :style='{"border":"0px solid #2a2d2e","cursor":"pointer","padding":"20px 20px 20px 30px","boxShadow":"inset 0px 0px 0px 0px rgba(19,161,230,.1)","margin":"0px","color":"#fff","textAlign":"center","letterSpacing":"10px","minWidth":"150px","outline":"none","borderRadius":"0px","background":"#c8b670","width":"auto","fontSize":"24px","fontWeight":"500","height":"auto"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
          <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0 10px","margin":"0 5px 5px","borderColor":"#72bc78","color":"#666","outline":"none","borderRadius":"0px","background":"none","borderWidth":"0 0 0 0px","width":"auto","fontSize":"inherit","borderStyle":"solid","fontWeight":"500","height":"auto"}' type="primary" @click="register('yonghu')" class="register">注册用户</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>
import menu from "@/utils/menu";
export default {
  data() {
    return {
		verifyCheck2: false,
		flag: false,
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
      },
      menus: [],
      roles: [],
      tableName: "",
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {

  },
  destroyed() {
	    },
  components: {
  },
  methods: {
	setVerify() {
		this.flag = true



		this.$nextTick(() => {
			new RotateVerify('#option3', {
				initText: '滑动将图片转正',
				slideImage: [{"name":"001.jpg","uid":1692687334825,"url":"http://codegen.caihongy.cn/20230822/ed0f74c2acf843d48a19cfea7b3d82cb.jpg","status":"success"},{"name":"002.jpg","uid":1692687338795,"url":"http://codegen.caihongy.cn/20230822/070967da153548eda3fa5afd9fba40e2.jpg","status":"success"},{"name":"003.jpg","uid":1692687343859,"url":"http://codegen.caihongy.cn/20230822/29a0639f21754316aeda0b853ad4d023.jpg","status":"success"}].map((item)=>{return item.url}),
				slideAreaNum: 10,
				getSuccessState: () => {
				setTimeout(()=>{
				  this.flag = false
				  this.loginPost()
				},2500)
				}
			})
		})

	},

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
		this.$router.push({path:'/register',query:{pageFlag:'register'}})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}
		

		this.setVerify()

    },
	loginPost() {
		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/" });
			} else {
				this.$message.error(data.msg);
			}
		});
	},
  }
}
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20230831/14552f0035244c0392b42406c14a0e3d.jpg);
        
  .list-item /deep/ .el-input .el-input__inner {
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: 480px;
		font-size: inherit;
		border-color: #e6e6e6;
		border-width: 0 0 1px;
		border-style: solid;
		height: 40px;
	  }
  
  .list-item.select /deep/ .el-select .el-input__inner {
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		width: 480px;
		font-size: 14px;
		border-color: #e6e6e6;
		border-width: 0 0 1px;
		border-style: solid;
		height: 44px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border-radius: 0px 0 0 0px;
  	  	padding: 0 10px;
  	  	outline: none;
  	  	color: #666;
  	  	background: none;
  	  	width: 400px;
  	  	font-size: inherit;
  	  	border-color: #e6e6e6;
  	  	border-width: 0 0 1px;
  	  	border-style: solid;
  	  	height: 40px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: #999;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        background: #c8b670;
        border-color: #c8b670;
      }
  .list-type /deep/ .el-radio__label {
		color: #666666;
		font-size: 16px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: rgba(50,50,50,1);
        font-size: 16px;
      }
}

	#option3 /deep/ .control-bor-wrap {
				border: 1px solid transparent;
				border-radius: 40px;
				top: 0;
				left: 0;
				width: 40px;
				position: absolute;
				height: 40px;
			}
	
	#option3 /deep/ .control-bor-wrap.control-bor-active {
				border: 1px solid #1a91ed;
			}
	
	#option3 /deep/ .control-bor-wrap.control-bor-suc {
				border: 1px solid rgb(92, 184, 92);
			}
	
	#option3 /deep/ .control-bor-wrap.control-bor-err {
				border: 1px solid red;
			}
	
	#option3 /deep/ .control-btn-wrap {
				border: 1px solid #e0e0e0;
				border-radius: 40px;
				top: 0;
				color: #666;
				left: 0;
				background: #fff;
				display: flex;
				width: 40px;
				justify-content: center;
				align-items: center;
				position: absolute;
				height: 40px;
			}
	
	#option3 /deep/ .control-btn-wrap.control-btn-active {
				color: #fff;
				background: #1a91ed;
			}
	
	#option3 /deep/ .control-btn-wrap.control-btn-suc {
				color: #fff;
				background: rgb(92, 184, 92);
			}
	
	#option3 /deep/ .control-btn-wrap.control-btn-err {
				color: #fff;
				background: red;
			}
</style>

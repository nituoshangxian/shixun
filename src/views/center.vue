<template>

  <div :style='{"padding":"0px","margin":"0 auto","color":"#333","borderRadius":"0 0 10px 10px","background":"rgba(255,255,255,.0)","width":"96%","fontSize":"16px"}'>
<!--    <el-form-->
<!--	  :style='{"border":"1px solid #dcd6c3","padding":"40px 0 20px","boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","margin":"30px 0 0","borderRadius":"4px","alignItems":"center","flexWrap":"wrap","background":"rgba(255,255,255,.69)","display":"flex","fontSize":"inherit"}'-->
<!--      class="add-update-preview"-->
<!--      ref="ruleForm"-->
<!--      :model="ruleForm"-->
<!--      label-width="150px"-->
<!--    >  -->
    <el-form
        ref="ruleForm"
        :model="ruleForm"
        :rules="rules"
        label-position="right"
        label-width="150px"
        :style='{"border":"1px solid #dcd6c3","padding":"40px 0 20px","boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","margin":"30px 0 0","borderRadius":"4px","alignItems":"center","flexWrap":"wrap","background":"rgba(255,255,255,.69)","display":"flex","fontSize":"inherit"}'
        class="add-update-preview form-wrapper"
    >
     <el-row>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='yonghu'"  label="用户账号" prop="yonghuzhanghao">
          <el-input v-model="ruleForm.yonghuzhanghao" readonly              placeholder="用户账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='yonghu'"  label="用户姓名" prop="yonghuxingming">
          <el-input v-model="ruleForm.yonghuxingming"               placeholder="用户姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-if="flag=='yonghu'" label="头像" prop="touxiang">
          <file-upload
              :before-upload="beforeUpload"
              :on-remove="handleRemove"
              :limit="3"
              :on-exceed="handleExceed"
          >
          </file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-if="flag=='yonghu'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in yonghuxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='yonghu'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='yonghu'"  label="小区名称" prop="xiaoqumingcheng">
          <el-input v-model="ruleForm.xiaoqumingcheng"               placeholder="小区名称" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='yonghu'"  label="楼栋" prop="loudong">
          <el-input v-model="ruleForm.loudong"               placeholder="楼栋" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='yonghu'"  label="房号" prop="fanghao">
          <el-input v-model="ruleForm.fanghao"               placeholder="房号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='yonghu'"  label="身份证" prop="shenfenzheng">
          <el-input v-model="ruleForm.shenfenzheng"               placeholder="身份证" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='yonghu'"  label="联系方式" prop="lianxifangshi">
          <el-input v-model="ruleForm.lianxifangshi"               placeholder="联系方式" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='shequyisheng'"  label="医生工号" prop="yishenggonghao">
          <el-input v-model="ruleForm.yishenggonghao" readonly              placeholder="医生工号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='shequyisheng'"  label="医生姓名" prop="yishengxingming">
          <el-input v-model="ruleForm.yishengxingming"               placeholder="医生姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-if="flag=='shequyisheng'" label="照片" prop="zhaopian">
          <file-upload
          tip="点击上传照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.zhaopian?ruleForm.zhaopian:''"
          @change="shequyishengzhaopianUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-if="flag=='shequyisheng'"  label="科室" prop="keshi">
          <el-select v-model="ruleForm.keshi" :disabled="true" placeholder="请选择科室">
            <el-option
                v-for="(item,index) in shequyishengkeshiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-if="flag=='shequyisheng'"  label="级别" prop="jibie">
          <el-select v-model="ruleForm.jibie" :disabled="true" placeholder="请选择级别">
            <el-option
                v-for="(item,index) in shequyishengjibieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='shequyisheng'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='shequyisheng'"  label="擅长疾病" prop="shanzhangjibing">
          <el-input v-model="ruleForm.shanzhangjibing"               placeholder="擅长疾病" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}'   v-if="flag=='shequyisheng'"  label="职业履历" prop="zhiyelvli">
          <el-input v-model="ruleForm.zhiyelvli"               placeholder="职业履历" clearable></el-input>
        </el-form-item>
		<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-if="flag=='users'" label="用户名" prop="username">
			<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-if="flag=='users'" label="头像" prop="image">
		  <file-upload
		  tip="点击上传头像"
		  action="file/upload"
		  :limit="1"
		  :multiple="false"
		  :fileUrls="ruleForm.image?ruleForm.image:''"
		  @change="usersimageUploadChange"
		  ></file-upload>
		</el-form-item>
		<el-form-item :style='{"padding":"40px 0","margin":"0","alignItems":"center","textAlign":"center","display":"flex","width":"100%","fontSize":"48px","justifyContent":"center"}'>
			<el-button class="btn3" :style='{"border":"1px solid #eee","cursor":"pointer","padding":"0 20px","margin":"0px 10px","color":"#333","transition":"all 0s","outline":"none","borderRadius":"4px","background":"none","width":"auto","fontSize":"16px","lineHeight":"24px","height":"40px"}' type="primary" @click="onUpdateHandler">
				<span class="icon iconfont icon-tijiao16" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
				提交
			</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      yonghuxingbieOptions: [],
      shequyishengkeshiOptions: [],
      shequyishengjibieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.yonghuxingbieOptions = "男,女".split(',')
    this.$http({
      url: `option/keshi/keshi`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.shequyishengkeshiOptions = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.shequyishengjibieOptions = "专家,主任医师,副主任医师,主治医师".split(',')
  },
  methods: {
    yonghutouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    shequyishengzhaopianUploadChange(fileUrls) {
        this.ruleForm.zhaopian = fileUrls;
    },
	usersimageUploadChange(fileUrls) {
		this.ruleForm.image = fileUrls;
	},
    onUpdateHandler() {
      if((!this.ruleForm.yonghuzhanghao)&& 'yonghu'==this.flag){
        this.$message.error('用户账号不能为空');
        return
      }

        if(this.ruleForm.yonghuzhanghao && ((this.ruleForm.yonghuzhanghao).toString().length<3) && `yonghu` == this.flag){
            this.$message.error(`用户账号长度不能小于3`);
            return
        }

        if(this.ruleForm.yonghuzhanghao && ((this.ruleForm.yonghuzhanghao).toString().length>10) && `yonghu` == this.flag){
            this.$message.error(`用户账号长度不能大于10`);
            return
        }
      if((!this.ruleForm.mima)&& 'yonghu'==this.flag){
        this.$message.error('密码不能为空');
        return
      }

        if(this.ruleForm.mima && ((this.ruleForm.mima).toString().length<3) && `yonghu` == this.flag){
            this.$message.error(`密码长度不能小于3`);
            return
        }

        if(this.ruleForm.mima && ((this.ruleForm.mima).toString().length>10) && `yonghu` == this.flag){
            this.$message.error(`密码长度不能大于10`);
            return
        }




        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }




      if( 'yonghu' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`年龄应输入整数`);
        return
      }








      if( 'yonghu' ==this.flag && this.ruleForm.shenfenzheng&&(!checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }


      if( 'yonghu' ==this.flag && this.ruleForm.lianxifangshi&&(!isMobile(this.ruleForm.lianxifangshi))){
        this.$message.error(`联系方式应输入手机格式`);
        return
      }


      if( 'yonghu' ==this.flag && this.ruleForm.status&&(!isIntNumer(this.ruleForm.status))){
       this.$message.error(`状态应输入整数`);
        return
      }


      if( 'yonghu' ==this.flag && this.ruleForm.passwordwrongnum&&(!isIntNumer(this.ruleForm.passwordwrongnum))){
       this.$message.error(`密码错误次数应输入整数`);
        return
      }








        if(this.ruleForm.zhaopian!=null) {
                this.ruleForm.zhaopian = this.ruleForm.zhaopian.replace(new RegExp(this.$base.url,"g"),"");
        }






      if( 'shequyisheng' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }




      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
	  if(this.flag=='users'){
	  	this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
	  }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
				if(this.flag=='users'){
					this.$storage.set('headportrait',this.ruleForm.image)
				}
            }
          });
        } else {
          this.$message.error(data.msg);
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
	
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>

<template>
	<div class="addEdit-block" :style='{"padding":"0 30px","margin":"0 auto","color":"#666","borderRadius":"4px","background":"none","width":"96%","fontSize":"16px"}'>
		<el-form
			:style='{"border":"1px solid #dcd6c3","padding":"40px 0 20px","boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","margin":"30px 0 0","borderRadius":"4px","alignItems":"center","flexWrap":"wrap","background":"rgba(255,255,255,.69)","display":"flex","fontSize":"inherit"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
		>
			<template >
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" clearable  :readonly="ro.yonghuzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" clearable  :readonly="ro.yonghuxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="upload" v-if="type!='info' && !ro.touxiang" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="touxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="upload" v-else-if="ruleForm.touxiang" label="头像" prop="touxiang">
					<img v-if="ruleForm.touxiang.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.touxiang.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.touxiang.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="性别" prop="xingbie">
					<el-input v-model="ruleForm.xingbie" placeholder="性别" clearable  :readonly="ro.xingbie"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="性别" prop="xingbie">
					<el-input v-model="ruleForm.xingbie" placeholder="性别" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="年龄" prop="nianling">
					<el-input v-model.number="ruleForm.nianling" placeholder="年龄" clearable  :readonly="ro.nianling"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="年龄" prop="nianling">
					<el-input v-model="ruleForm.nianling" placeholder="年龄" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="身高(cm)" prop="shengao">
					<el-input v-model.number="ruleForm.shengao" placeholder="身高(cm)" clearable  :readonly="ro.shengao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="身高(cm)" prop="shengao">
					<el-input v-model="ruleForm.shengao" placeholder="身高(cm)" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="体重(kg)" prop="tizhong">
					<el-input-number v-model="ruleForm.tizhong" placeholder="体重(kg)" :disabled="ro.tizhong"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="体重(kg)" prop="tizhong">
					<el-input v-model="ruleForm.tizhong" placeholder="体重(kg)" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="视力" prop="shili">
					<el-input-number v-model="ruleForm.shili" placeholder="视力" :disabled="ro.shili"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="视力" prop="shili">
					<el-input v-model="ruleForm.shili" placeholder="视力" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="心率(b/min)" prop="xinlv">
					<el-input v-model.number="ruleForm.xinlv" placeholder="心率(b/min)" clearable  :readonly="ro.xinlv"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="心率(b/min)" prop="xinlv">
					<el-input v-model="ruleForm.xinlv" placeholder="心率(b/min)" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="血压(mmHg)" prop="xueya">
					<el-input v-model.number="ruleForm.xueya" placeholder="血压(mmHg)" clearable  :readonly="ro.xueya"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="血压(mmHg)" prop="xueya">
					<el-input v-model="ruleForm.xueya" placeholder="血压(mmHg)" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="血糖(mmol/L)" prop="xuetang">
					<el-input-number v-model="ruleForm.xuetang" placeholder="血糖(mmol/L)" :disabled="ro.xuetang"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="血糖(mmol/L)" prop="xuetang">
					<el-input v-model="ruleForm.xuetang" placeholder="血糖(mmol/L)" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="血脂(mmol/L)" prop="xuezhi">
					<el-input-number v-model="ruleForm.xuezhi" placeholder="血脂(mmol/L)" :disabled="ro.xuezhi"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="血脂(mmol/L)" prop="xuezhi">
					<el-input v-model="ruleForm.xuezhi" placeholder="血脂(mmol/L)" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="date" v-if="type!='info'" label="更新时间" prop="gengxinshijian">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.gengxinshijian" 
						type="date"
						:readonly="ro.gengxinshijian"
						placeholder="更新时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-else-if="ruleForm.gengxinshijian" label="更新时间" prop="gengxinshijian">
					<el-input v-model="ruleForm.gengxinshijian" placeholder="更新时间" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"padding":"40px 0","margin":"0","alignItems":"center","textAlign":"center","display":"flex","width":"100%","fontSize":"48px","justifyContent":"center"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao16" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao09" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui01" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
import { 
	isNumber,
	isIntNumer,
} from "@/utils/validate";
export default {
	data() {
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				yonghuzhanghao : false,
				yonghuxingming : false,
				touxiang : false,
				xingbie : false,
				nianling : false,
				shengao : false,
				tizhong : false,
				shili : false,
				xinlv : false,
				xueya : false,
				xuetang : false,
				xuezhi : false,
				gengxinshijian : false,
			},
			
			
			ruleForm: {
				yonghuzhanghao: '',
				yonghuxingming: '',
				touxiang: '',
				xingbie: '',
				nianling: '',
				shengao: '',
				tizhong: '',
				shili: '',
				xinlv: '',
				xueya: '',
				xuetang: '',
				xuezhi: '',
				gengxinshijian: '',
			},
		

			
			rules: {
				yonghuzhanghao: [
				],
				yonghuxingming: [
				],
				touxiang: [
				],
				xingbie: [
				],
				nianling: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				shengao: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				tizhong: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				shili: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				xinlv: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				xueya: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				xuetang: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				xuezhi: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				gengxinshijian: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.gengxinshijian = this.getCurDate()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='yonghuzhanghao'){
							this.ruleForm.yonghuzhanghao = obj[o];
							this.ro.yonghuzhanghao = true;
							continue;
						}
						if(o=='yonghuxingming'){
							this.ruleForm.yonghuxingming = obj[o];
							this.ro.yonghuxingming = true;
							continue;
						}
						if(o=='touxiang'){
							this.ruleForm.touxiang = obj[o];
							this.ro.touxiang = true;
							continue;
						}
						if(o=='xingbie'){
							this.ruleForm.xingbie = obj[o];
							this.ro.xingbie = true;
							continue;
						}
						if(o=='nianling'){
							this.ruleForm.nianling = obj[o];
							this.ro.nianling = true;
							continue;
						}
						if(o=='shengao'){
							this.ruleForm.shengao = obj[o];
							this.ro.shengao = true;
							continue;
						}
						if(o=='tizhong'){
							this.ruleForm.tizhong = obj[o];
							this.ro.tizhong = true;
							continue;
						}
						if(o=='shili'){
							this.ruleForm.shili = obj[o];
							this.ro.shili = true;
							continue;
						}
						if(o=='xinlv'){
							this.ruleForm.xinlv = obj[o];
							this.ro.xinlv = true;
							continue;
						}
						if(o=='xueya'){
							this.ruleForm.xueya = obj[o];
							this.ro.xueya = true;
							continue;
						}
						if(o=='xuetang'){
							this.ruleForm.xuetang = obj[o];
							this.ro.xuetang = true;
							continue;
						}
						if(o=='xuezhi'){
							this.ruleForm.xuezhi = obj[o];
							this.ro.xuezhi = true;
							continue;
						}
						if(o=='gengxinshijian'){
							this.ruleForm.gengxinshijian = obj[o];
							this.ro.gengxinshijian = true;
							continue;
						}
				}
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
					if(((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
						this.ro.yonghuzhanghao = true;
					}
					if(((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yonghuxingming = json.yonghuxingming
						this.ro.yonghuxingming = true;
					}
					if(((json.touxiang!=''&&json.touxiang) || json.touxiang==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.touxiang = json.touxiang
						this.ro.touxiang = true;
					}
					if(((json.xingbie!=''&&json.xingbie) || json.xingbie==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.xingbie = json.xingbie
						this.ro.xingbie = true;
					}
					if(((json.nianling!=''&&json.nianling) || json.nianling==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.nianling = json.nianling
						this.ro.nianling = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `jiankangxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
	if(this.ruleForm.touxiang!=null) {
		this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
	}
var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "jiankangxinxi/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `jiankangxinxi/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.jiankangxinxiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `jiankangxinxi/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.jiankangxinxiCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
			   }
			});
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.jiankangxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    touxiangUploadChange(fileUrls) {
	    this.ruleForm.touxiang = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
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
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
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
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
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
	
	.add-update-preview /deep/ .upload .upload-img {
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
	
	.add-update-preview .btn .btn1 {
				border: 1px solid #eee;
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 10px;
				color: #333;
				display: inline-block;
				font-size: 16px;
				line-height: 24px;
				transition: all 0s;
				border-radius: 4px;
				outline: none;
				background: none;
				width: auto;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				border: 1px solid #bda75c;
				color: #bda75c;
				background: linear-gradient(180deg, rgba(255,248,216,1) 0%, rgba(231,223,184,1) 100%),#fff;
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 1px solid #eee;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 20px;
				margin: 0px 10px;
				color: #333;
				background: none;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				transition: all 0s;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				border: 1px solid #bda75c;
				color: #bda75c;
				background: linear-gradient(180deg, rgba(255,248,216,1) 0%, rgba(231,223,184,1) 100%),#fff;
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
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
	
	.add-update-preview .btn .btn3:hover {
				border: 1px solid #bda75c;
				transform: skew(0deg, 0deg);
				color: #bda75c;
				background: linear-gradient(180deg, rgba(255,248,216,1) 0%, rgba(231,223,184,1) 100%),#fff;
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 1px solid #eee;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 20px;
				margin: 0px 10px;
				color: #333;
				background: none;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				transition: all 0s;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				border: 1px solid #bda75c;
				color: #bda75c;
				background: linear-gradient(180deg, rgba(255,248,216,1) 0%, rgba(231,223,184,1) 100%),#fff;
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 1px solid #eee;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 20px;
				margin: 0 10px;
				color: #333;
				background: none;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				border: 1px solid #bda75c;
				color: #bda75c;
				background: linear-gradient(180deg, rgba(255,248,216,1) 0%, rgba(231,223,184,1) 100%),#fff;
				opacity: 0.8;
			}
</style>

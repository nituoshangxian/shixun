<template>
	<div class="main-content" :style='{"padding":"0px","margin":"0 auto","color":"#333","borderRadius":"0 0 10px 10px","background":"rgba(255,255,255,.0)","width":"96%","fontSize":"16px"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"padding":"0px","margin":"20px 0 0","overflow":"hidden","color":"#666","flexWrap":"wrap","background":"none","display":"flex","fontSize":"inherit","justifyContent":"space-between"}' :inline="true" :model="searchForm">
				<el-row :style='{"border":"1px solid #dcd6c3","padding":"10px 20px","margin":"0 30px 30px 0","alignItems":"center","borderRadius":"8px","flexWrap":"wrap","background":"rgba(251,249,243,.9)","display":"flex","width":"auto","fontSize":"18px","justifyContent":"center"}' >
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"inherit","display":"inline-block","lineHeight":"40px","fontSize":"inherit","fontWeight":"500","height":"40px"}' class="item-label">用户账号</label>
						<el-input v-model="searchForm.yonghuzhanghao" placeholder="用户账号" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"inherit","display":"inline-block","lineHeight":"40px","fontSize":"inherit","fontWeight":"500","height":"40px"}' class="item-label">用户姓名</label>
						<el-input v-model="searchForm.yonghuxingming" placeholder="用户姓名" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","display":"inline-block"}' class="select" label="健康评价" prop="jiankangpingjia">
						<label :style='{"margin":"0 10px 0 0","color":"inherit","display":"inline-block","lineHeight":"40px","fontSize":"inherit","fontWeight":"500","height":"40px"}' class="item-label">健康评价</label>
						<el-select clearable v-model="searchForm.jiankangpingjia" placeholder="请选择健康评价" >
							<el-option v-for="(item,index) in jiankangpingjiaOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<el-button class="search" type="success" @click="search()">
						<span class="icon iconfont icon-chakan12" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","height":"40px"}'></span>
						查找
					</el-button>
				</el-row>

				<el-row class="actions" :style='{"border":"1px solid #dcd6c3","padding":"10px 20px","margin":"0 0 30px","color":"#666","alignItems":"center","display":"flex","-webkitPerspective":"320px","justifyContent":"center","borderRadius":"8px","flexWrap":"wrap","flex":"1","background":"rgba(251,249,243,.9)","width":"auto","perspective":"320px","fontSize":"18px"}'>
					<el-button class="add" v-if="isAuth('tijianbaogao','新增')" type="success" @click="addOrUpdateHandler()">
						<span class="icon iconfont icon-tianjia17" :style='{"color":"inherit","margin":"0 2px","fontSize":"inherit"}'></span>
						添加
					</el-button>
					<el-button class="del" v-if="isAuth('tijianbaogao','删除')" :disabled="dataListSelections.length?false:true" type="danger" @click="deleteHandler()">
						<span class="icon iconfont icon-shanchu6" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","height":"40px"}'></span>
						删除
					</el-button>



					<el-button class="btn18" v-if="isAuth('tijianbaogao','体检结果统计')" type="success" @click="chartDialog1()">
						<span class="icon iconfont icon-a-fenxiang2" :style='{"color":"inherit","margin":"0 2px","fontSize":"inherit"}'></span>
						体检结果统计
					</el-button>
				</el-row>
			</el-form>
			<div :style='{"padding":"0 30px","borderColor":"#eee","margin":"30px 0 0","borderRadius":"0px","background":"rgba(255,255,255,.69)","borderWidth":"0px 0 0 0px","width":"100%","borderStyle":"solid"}'>
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","borderColor":"rgba(19,161,230,.2)","color":"inherit","borderRadius":"0px","borderWidth":"0","background":"none","width":"100%","fontSize":"inherit","borderStyle":"solid"}' 
					:border='true'
					v-if="isAuth('tijianbaogao','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'  
						prop="yonghuzhanghao"
						label="用户账号">
						<template slot-scope="scope">
							{{scope.row.yonghuzhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="yonghuxingming"
						label="用户姓名">
						<template slot-scope="scope">
							{{scope.row.yonghuxingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="touxiang" width="200" label="头像">
						<template slot-scope="scope">
							<div v-if="scope.row.touxiang">
								<img v-if="scope.row.touxiang.substring(0,4)=='http'" :src="scope.row.touxiang.split(',')[0]" width="100" height="100" style="object-fit: cover" @click="imgPreView(scope.row.touxiang.split(',')[0])">
								<img v-else :src="$base.url+scope.row.touxiang.split(',')[0]" width="100" height="100" style="object-fit: cover" @click="imgPreView($base.url+scope.row.touxiang.split(',')[0])">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="lianxifangshi"
						label="联系方式">
						<template slot-scope="scope">
							{{scope.row.lianxifangshi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="zangqigongneng"
						label="脏器功能">
						<template slot-scope="scope">
							{{scope.row.zangqigongneng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="chati"
						label="查体">
						<template slot-scope="scope">
							{{scope.row.chati}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="jiankangwenti"
						label="健康问题">
						<template slot-scope="scope">
							{{scope.row.jiankangwenti}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="zhongyitizhi"
						label="中医体质">
						<template slot-scope="scope">
							{{scope.row.zhongyitizhi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="jiankangpingjia"
						label="健康评价">
						<template slot-scope="scope">
							{{scope.row.jiankangpingjia}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="tijianriqi"
						label="体检日期">
						<template slot-scope="scope">
							{{scope.row.tijianriqi}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button class="view" v-if=" isAuth('tijianbaogao','查看')" type="success" @click="addOrUpdateHandler(scope.row.id,'info')">
								<span class="icon iconfont icon-chakan18" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"inline-block","height":"40px"}'></span>
								查看
							</el-button>
							<el-button class="edit" v-if=" isAuth('tijianbaogao','修改') " type="success" @click="addOrUpdateHandler(scope.row.id)">
								<span class="icon iconfont icon-xiugai11" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"inline-block","height":"40px"}'></span>
								修改
							</el-button>




							<el-button class="del" v-if="isAuth('tijianbaogao','删除') " type="primary" @click="deleteHandler(scope.row.id )">
								<span class="icon iconfont icon-shanchu6" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"inline-block","height":"40px"}'></span>
								删除
							</el-button>
						</template>
					</el-table-column>
				</el-table>
			</div>
			<el-pagination
				@size-change="sizeChangeHandle"
				@current-change="currentChangeHandle"
				:current-page="pageIndex"
				background
				:page-sizes="[10, 50, 100, 200]"
				:page-size="pageSize"
				:layout="layouts.join()"
				:total="totalPage"
				prev-text="上一页 "
				next-text="下一页 "
				:hide-on-single-page="false"
				:style='{"padding":"10px","margin":"20px 0 0","whiteSpace":"nowrap","color":"inherit","textAlign":"center","background":"rgba(255,255,255,.69)","width":"100%","fontSize":"inherit","fontWeight":"500"}'
			></el-pagination>
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>




		<el-dialog
		  :visible.sync="chartVisiable1"
		  width="800">
			<div id="jiankangpingjiaChart1" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog1">返回</el-button>
		  </span>
		</el-dialog>

		<el-dialog title="预览图" :visible.sync="previewVisible" width="50%">
			<img :src="previewImg" alt="" style="width: 100%;">
		</el-dialog>
	</div>
</template>

<script>
import * as echarts from 'echarts'
import chinaJson from "@/components/echarts/china.json";
import axios from 'axios'
import AddOrUpdate from "./add-or-update.vue";
	export default {
		data() {
			return {
				jiankangpingjiaOptions: [],
				searchForm: {
					key: ""
				},
				form:{},
				dataList: [],
				pageIndex: 1,
				pageSize: 10,
				totalPage: 0,
				dataListLoading: false,
				dataListSelections: [],
				showFlag: true,
				chartVisiable1: false,
				addOrUpdateFlag:false,
				layouts: ["total","prev","pager","next","sizes","jumper"],
				previewImg: '',
				previewVisible: false,
			};
		},
		created() {
			this.init();
			this.getDataList();
			this.contentStyleChange()
		},
		mounted() {
		},
		filters: {
			htmlfilter: function (val) {
				return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
			}
		},
		computed: {
			tablename(){
				return this.$storage.get('sessionTable')
			},
		},
		components: {
			AddOrUpdate,
		},
		methods: {
			imgPreView(url){
				this.previewImg = url
				this.previewVisible = true
			},
			contentStyleChange() {
				this.contentPageStyleChange()
			},
			// 分页
			contentPageStyleChange(){
				let arr = []

				// if(this.contents.pageTotal) arr.push('total')
				// if(this.contents.pageSizes) arr.push('sizes')
				// if(this.contents.pagePrevNext){
				//   arr.push('prev')
				//   if(this.contents.pagePager) arr.push('pager')
				//   arr.push('next')
				// }
				// if(this.contents.pageJumper) arr.push('jumper')
				// this.layouts = arr.join()
				// this.contents.pageEachNum = 10
			},


//统计接口
    chartDialog1() {
      this.chartVisiable1 = !this.chartVisiable1;
      this.$nextTick(()=>{
        var jiankangpingjiaChart1 = echarts.init(document.getElementById("jiankangpingjiaChart1"),'dark');
        this.$http({
            url: "tijianbaogao/group/jiankangpingjia",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].jiankangpingjia);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].jiankangpingjia
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '体检结果统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:40
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                jiankangpingjiaChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    jiankangpingjiaChart1.resize();
                };
            }
        });
      })
    },




    init () {
          this.jiankangpingjiaOptions = "异常,无异常".split(',')
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.yonghuzhanghao!='' && this.searchForm.yonghuzhanghao!=undefined){
            params['yonghuzhanghao'] = '%' + this.searchForm.yonghuzhanghao + '%'
          }
           if(this.searchForm.yonghuxingming!='' && this.searchForm.yonghuxingming!=undefined){
            params['yonghuxingming'] = '%' + this.searchForm.yonghuxingming + '%'
          }
           if(this.searchForm.jiankangpingjia!='' && this.searchForm.jiankangpingjia!=undefined){
            params['jiankangpingjia'] = this.searchForm.jiankangpingjia
          }
    params['sort'] = 'tijianriqi';
    params['order'] = 'desc';
			let user = JSON.parse(this.$storage.getObj('userForm'))
			console.log(user)
			this.$http({
				url: "tijianbaogao/page",
				method: "get",
				params: params
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.dataList = data.data.list;
					this.totalPage = data.data.total;
				} else {
					this.dataList = [];
					this.totalPage = 0;
				}
				this.dataListLoading = false;
			});
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 下载
    download(file){
      let arr = file.replace(new RegExp('upload/', "g"), "")
      axios.get(this.$base.url + 'file/download?fileName=' + arr, {
      	headers: {
      		token: this.$storage.get('Token')
      	},
      	responseType: "blob"
      }).then(({
      	data
      }) => {
      	const binaryData = [];
      	binaryData.push(data);
      	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
      		type: 'application/pdf;chartset=UTF-8'
      	}))
      	const a = document.createElement('a')
      	a.href = objectUrl
      	a.download = arr
      	// a.click()
      	// 下面这个写法兼容火狐
      	a.dispatchEvent(new MouseEvent('click', {
      		bubbles: true,
      		cancelable: true,
      		view: window
      	}))
      	window.URL.revokeObjectURL(data)
      },err=>{
		  axios.get((location.href.split(this.$base.name).length>1 ? location.href.split(this.$base.name)[0] :'') + this.$base.name + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: this.$storage.get('Token')
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  })
	  })
    },
	// 预览
	preClick(file){
		if(!file){
			return false
		}
		window.open((location.href.split(this.$base.name).length>1 ? location.href.split(this.$base.name)[0] + this.$base.name + '/' + file :this.$base.url + file))
	},
	tijianbaogaostatusChange(e,row){
		if(row.status==0){
			row.passwordwrongnum = 0
		}
		this.$http({
			url:'tijianbaogao/update',
			method:'post',
			data:row
		}).then(res=>{
			if(row.status==1){
				this.$message.error('该用户已锁定')
			}else{
				this.$message.success('该用户已解除锁定')
			}
		})
	},
    // 删除
    async deleteHandler(id ) {
		var ids = id? [Number(id)]: this.dataListSelections.map(item => {
			return Number(item.id);
		});
		await this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
			confirmButtonText: "确定",
			cancelButtonText: "取消",
			type: "warning"
		}).then(async () => {
			await this.$http({
				url: "tijianbaogao/delete",
				method: "post",
				data: ids
			}).then(async ({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.search();
						}
					});
            
				} else {
					this.$message.error(data.msg);
				}
			});
		});
    },


  }

};
</script>
<style lang="scss" scoped>
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border-radius: 0px;
				padding: 0 12px;
				box-shadow: inset 0px 0px 0px 0px #fff;
				outline: none;
				color: inherit;
				background: none;
				width: 170px;
				font-size: 16px;
				border-color: #ccc;
				border-width: 0 0 1px;
				border-style: solid;
				height: 40px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border-radius: 0px;
				padding: 0 10px;
				box-shadow: inset 0px 0px 0px 0px #fff;
				outline: none;
				color: inherit;
				background: none;
				width: 170px;
				font-size: 16px;
				border-color: #ccc;
				border-width: 0 0 1px;
				border-style: solid;
				height: 40px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border-radius: 0px;
				padding: 0 10px 0 30px;
				box-shadow: inset 0px 0px 0px 0px #fff;
				outline: none;
				color: inherit;
				background: none;
				width: 170px;
				font-size: 16px;
				border-color: #ccc;
				border-width: 0 0 1px;
				border-style: solid;
				height: 40px;
			}
	
	.center-form-pv .search {
				border: 0px solid #47defa;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				outline: none;
				clip-path: polygon(100% 0%, 95% 51%, 100% 100%, 5% 100%, 0% 50%, 5% 0);
				color: #fff;
				background: #666;
				width: auto;
				font-size: inherit;
				height: 40px;
			}
	
	.center-form-pv .search:hover {
				transform: scale(1.08);
				color: #fff;
				background: #bda75c;
			}
	
	.center-form-pv .actions .add {
				cursor: pointer;
				padding: 0 16px 0 10px;
				margin: 4px 4px 5px;
				color: inherit;
				font-size: inherit;
				border-color: #eee;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: rgba(255,255,255,.9);
				width: auto;
				border-width: 1px;
				border-style: solid;
				height: 32px;
			}
	
	.center-form-pv .actions .add:hover {
				padding: 0 16px 2px 10px;
				color: #bda75c;
				background: rgba(255,255,255,1);
				border-color: #bda75c;
				border-width: 1px;
				opacity: 1;
				border-style: solid;
			}
	
	.center-form-pv .actions .del {
				cursor: pointer;
				padding: 0 16px 0 10px;
				margin: 4px 4px 5px;
				color: inherit;
				font-size: inherit;
				border-color: #eee;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: rgba(255,255,255,.9);
				width: auto;
				border-width: 1px;
				border-style: solid;
				height: 32px;
			}
	
	.center-form-pv .actions .del:hover {
				padding: 0 16px 2px 10px;
				color: #bda75c;
				background: rgba(255,255,255,1);
				border-color: #bda75c;
				border-width: 1px;
				opacity: 1;
				border-style: dolid;
			}
	
	.center-form-pv .actions .statis {
				cursor: pointer;
				padding: 0 16px 0 10px;
				margin: 4px 4px 5px;
				color: inherit;
				font-size: inherit;
				border-color: #eee;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: rgba(255,255,255,.9);
				width: auto;
				border-width: 1px;
				border-style: solid;
				height: 32px;
			}
	
	.center-form-pv .actions .statis:hover {
				padding: 0 16px 2px 10px;
				color: #bda75c;
				background: rgba(255,255,255,1);
				border-color: #bda75c;
				border-width: 1px;
				opacity: 1;
				border-style: solid;
			}
	
	.center-form-pv .actions .btn18 {
				cursor: pointer;
				padding: 0 16px 0 10px;
				margin: 4px 4px 5px;
				color: inherit;
				font-size: inherit;
				border-color: #eee;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: rgba(255,255,255,.9);
				width: auto;
				border-width: 1px;
				border-style: solid;
				height: 32px;
			}
	
	.center-form-pv .actions .btn18:hover {
				padding: 0 16px 2px 10px;
				color: #bda75c;
				background: rgba(255,255,255,1);
				border-color: #bda75c;
				border-width: 1px;
				opacity: 1;
				border-style: solid;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #333;
				background: rgba(254,169,34,0);
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: none;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 8px 0;
				background: none;
				border-color: rgba(189,168,92,.3);
				border-width: 0 0px 1px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: 600;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				font-size: 18px;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				padding: 0;
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: none;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 6px 0;
				color: inherit;
				background: none;
				font-size: inherit;
				border-color: rgba(189,168,92,.3);
				border-width: 0 0px 1px 0px;
				border-style: solid;
				text-align: left;
			}
	
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 6px 0;
				color: #666;
				background: rgba(255,255,255,.3);
				border-color: rgba(189,168,92,.3);
				border-width: 0 0px 1px 0px;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 6px 0;
				color: inherit;
				background: none;
				font-size: inherit;
				border-color: rgba(189,168,92,.3);
				border-width: 0 0px 1px 0px;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				color: inherit;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view {
				cursor: pointer;
				padding: 6px 6px 0 4px;
				margin: 6px 5px 6px 0;
				color: #333;
				font-size: 16px;
				border-color: #fff;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: rgba(255,255,255,.9);
				width: auto;
				border-width: 1px;
				border-style: solid;
				height: 32px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view:hover {
				color: #bda75c;
				border-color: #bda75c;
				border-width: 1px;
				opacity: 0.8;
				border-style: solid;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add:hover {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit {
				border: 0px solid rgba(254, 148, 34, .2);
				cursor: pointer;
				padding: 6px 6px 0 4px;
				margin: 6px 5px 6px 0;
				color: #333;
				font-size: 16px;
				border-color: #fff;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: rgba(255,255,255,.9);
				width: auto;
				border-width: 1px;
				border-style: solid;
				height: 32px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit:hover {
				color: #bda75c;
				border-color: #bda75c;
				border-width: 1px;
				opacity: 0.8;
				border-style: solid;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del {
				cursor: pointer;
				padding: 6px 6px 0 4px;
				margin: 6px 5px 6px 0;
				color: #333;
				font-size: 16px;
				border-color: #fff;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: rgba(255,255,255,.9);
				width: auto;
				border-width: 1px;
				border-style: solid;
				height: 32px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del:hover {
				color: #bda75c;
				border-color: #bda75c;
				border-width: 1px;
				opacity: 0.8;
				border-style: solid;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8 {
				cursor: pointer;
				padding: 6px 6px 0 4px;
				margin: 2px 5px 6px 0;
				color: #333;
				font-size: 16px;
				border-color: #fff;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: rgba(255,255,255,.9);
				width: auto;
				border-width: 1px;
				border-style: solid;
				height: 32px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8:hover {
				color: #bda75c;
				border-color: #bda75c;
				border-width: 1px;
				opacity: 0.8;
				border-style: solid;
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: inherit;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: inherit;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: inherit;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: #999;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: #999;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: inherit;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: rgba(189,168,92,.6);
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: rgba(189,168,92,.6);
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				color: inherit;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				color: inherit;
				width: 100px;
				font-size: inherit;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 0px solid #ddd;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: inherit;
				display: inline-block;
				font-size: inherit;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: none;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: inherit;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				color: inherit;
				display: inline-block;
				width: 50px;
				font-size: inherit;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				cursor: pointer;
				padding: 0 0px;
				color: inherit;
				display: inline-block;
				font-size: inherit;
				border-color: #eee;
				line-height: 24px;
				border-radius: 2px;
				background: none;
				width: auto;
				border-width: 1px;
				border-style: solid;
				text-align: center;
				height: 24px;
			}
	
	// list one
	.one .list1-view {
				cursor: pointer;
				padding: 0 6px 0 4px;
				margin: 6px 5px 6px 0;
				color: #333;
				font-size: inherit;
				border-color: #fbf9f3;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: rgba(86,178,198,.0);
				width: auto;
				border-width: 1px;
				border-style: solid;
				height: 32px;
			}
	
	.one .list1-view:hover {
				color: #bda75c;
				border-color: #bda75c;
				border-width: 1px;
				opacity: 0.8;
				border-style: solid;
			}
	
	.one .list1-edit {
				border: 0px solid rgba(254, 148, 34, .2);
				cursor: pointer;
				padding: 0 6px 0 4px;
				margin: 6px 5px 6px 0;
				color: #333;
				font-size: inherit;
				border-color: #fbf9f3;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: none;
				width: auto;
				border-width: 1px;
				border-style: solid;
				height: 32px;
			}
	
	.one .list1-edit:hover {
				color: #bda75c;
				border-color: #bda75c;
				border-width: 1px;
				opacity: 0.8;
				border-style: solid;
			}
	
	.one .list1-del {
				border: 0px solid rgba(180, 52, 31, .2);
				cursor: pointer;
				padding: 0 6px 0 4px;
				margin: 6px 5px 6px 0;
				color: #333;
				font-size: inherit;
				border-color: #fbf9f3;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: rgba(255, 0, 0, 0);
				width: auto;
				border-width: 1px;
				border-style: solid;
				height: 32px;
			}
	
	.one .list1-del:hover {
				color: #bda75c;
				border-color: #bda75c;
				border-width: 1px;
				opacity: 0.8;
				border-style: solid;
			}
	
	.one .list1-btn8 {
				border: 0px solid rgba(31, 160, 180, .2);
				cursor: pointer;
				padding: 0 6px 0 4px;
				margin: 6px 5px 6px 0;
				color: #333;
				font-size: inherit;
				border-color: #fbf9f3;
				transition: all 0.3s;
				border-radius: 4px;
				outline: none;
				background: rgba(255, 128, 0, 0);
				width: auto;
				border-width: 1px;
				border-style: solid;
				height: 32px;
			}
	
	.one .list1-btn8:hover {
				color: #bda75c;
				border-color: #bda75c;
				border-width: 1px;
				opacity: 0.8;
				border-style: solid;
			}
	
	.main-content .el-table .el-switch {
				display: inline-flex;
				vertical-align: middle;
				line-height: 30px;
				position: relative;
				align-items: center;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__label--left {
				cursor: pointer;
				margin: 0 10px 0 0;
				color: #333;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__label--right {
				cursor: pointer;
				margin: 0 0 0 10px;
				color: #333;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__core {
				border: 1px solid #bda75c;
				cursor: pointer;
				border-radius: 15px;
				margin: 0;
				outline: 0;
				background: #bda75c;
				display: inline-block;
				width: 50px;
				box-sizing: border-box;
				transition: border-color .3s,background-color .3s;
				height: 24px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__core::after {
				border-radius: 100%;
				top: 1px;
				left: 1px;
				background: #fff;
				width: 20px;
				position: absolute;
				transition: all .3s;
				height: 20px;
			}
	.main-content .el-table .el-switch.is-checked /deep/ .el-switch__core::after {
				margin: 0 0 0 -27px;
				left: 100%;
				background: #fff;
			}
	
	.main-content .el-table .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	.main-content .el-table .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				color: #666;
				display: inline-block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}

</style>

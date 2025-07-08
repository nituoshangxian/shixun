const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot01389843/",
            name: "springboot01389843",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: " 智慧医养大数据公共服务平台医生服务系统"
        } 
    }
}
export default base

const base = {
    get() {
        return {
            url : "http://localhost:8080/ZHYY/",
            name: "ZHYY",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "基于JavaWeb的社区老人健康管理系统设计与实现"
        } 
    }
}
export default base

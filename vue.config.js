// var webpack = require('webpack');
//vue2
const path = require('path');
function resolve(dir) {
    return path.join(__dirname, dir);
}

module.exports = {
    publicPath: '/', // 始终使用根路径（兼容 Spring Boot 上下文路径）
    outputDir: path.resolve(__dirname, '../src/main/resources/static'), // 输出到 Spring Boot 静态目录
    lintOnSave: false,
    devServer: {
        host: "0.0.0.0",
        port: 8081,
        proxy: {
            '/springboot01389843': {
                target: 'http://localhost:8080/springboot01389843/',
                changeOrigin: true,
                pathRewrite: {
                    '^/springboot01389843': ''
                }
            }
        }
    },
    configureWebpack: {
        resolve: {
            alias: {
                '@': path.resolve(__dirname, 'src')
                // '@': resolve('src')
            }
        }
    },
    chainWebpack(config) {
        config.module
            .rule('svg')
            .exclude.add(resolve('src/icons'))
            .end();
        config.module
            .rule('icons')
            .test(/\.svg$/)
            .include.add(resolve('src/icons'))
            .end()
            .use('svg-sprite-loader')
            .loader('svg-sprite-loader')
            .options({
                symbolId: 'icon-[name]'
            });
    }
};
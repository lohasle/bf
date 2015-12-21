/**
 * Created by fule on 14-6-5.
 * require main.js
 */
/**
 * Created by lohas on 2015/3/27.
 * https://github.com/lohasle
 * To change this template use File | Settings | File Templates.
 */
/**
 * 主题风格
 * @type {string}
 */
function getThemeName() {
    return SERVER_CONSTANT.THEME && SERVER_CONSTANT.THEME != '' ? SERVER_CONSTANT.THEME : "default";
}
var baseUrl  = location.origin+SERVER_CONSTANT.CTX+"/static/js/";
require.config({
    timeout:"60000",
    baseUrl: baseUrl,
    urlArgs: "v=" + (new Date()).getTime(),    //debug
    paths: {
        /*jquery:"lib/jquery-1.9.1",*/
        //css插件
        css: 'lib/css',
        //image插件
        image: 'lib/image',
        //css依赖的插件
        normalize: 'lib/normalize'
    },
    shim: {

        /*"lib/jquery-1.9.1":{
            exports:"jQuery"
        },*/
        /** bootsharp **/
        "lib/bootstrap.min":{
            deps: ['jquery'],
            exports: "jQuery.fn.bootstrap"
        },

        /** jqgrid **/
        "lib/jqGrid/jquery.jqGrid.min":{
            deps: ['jquery', 'lib/jqGrid/i18n/grid.locale-zh_CN'],
            exports: "jQuery.fn.jqGrid"
        },


        /** ace **/
        "lib/ace.min":{
            deps: ['jquery','lib/ace-extra.min','lib/ace-elements.min'],
            exports: ""
        },

        /**弹出框**/
        "lib/bootbox.min":{
            deps: ['jquery'],
            exports: "jQuery.fn.bootbox"
        },


        /**搜索提示**/
        "lib/typeahead-bs2.min":{
            deps: ['jquery'],
            exports: "jQuery.fn.typeahead"
        },

        /**响应式**/
        "lib/respond.min":{
            deps: ['jquery','lib/html5shiv'],
            exports: "jQuery.fn.respond"
        },

        /** select2  **/
        "lib/select2.min":{
            deps: ['jquery','lib/select2.min','css!../../css/select2'],
            exports: "jQuery.fn.respond"
        },

        /**日历**/
        "lib/date-time/bootstrap-datetimepicker.zh-CN":{
            deps: ["lib/date-time/bootstrap-datetimepicker.min"],
            exports: ""
        },
        "lib/date-time/bootstrap-datetimepicker.min":{
            deps: ['jquery','lib/bootstrap.min',,
                'css!../../../css/bootstrap-datetimepicker.min'],
            exports: "jQuery.fn.datepicker"
        },

        /** jquery from **/
        "lib/jquery.form":{
            deps: ['jquery'],
            exports: ""
        },
        /** jquery validate **/
        "lib/jquery.validate.additional-methods" :{
            deps: ['lib/jquery.validate.min'],
            exports: "jQuery.fn.validate"
        },
        "lib/jquery.validate.min":{
            deps: ['jquery','lib/bootstrap.min',
                'lib/date-time/bootstrap-datetimepicker.min'],
            exports: "jQuery.fn.validate"
        },



        "lib/jquery.mobile.custom.min":{
            deps: ['jquery'],
            exports: ""
        },

        "jquery-ui-1.10.3.custom.min":{
            deps: ['jquery','css!../../css/jquery-ui-1.10.3.full.min'],
            exports: ""
        },


        "lib/jquery.ui.touch-punch.min":{
            deps: ['jquery'],
            exports: ""
        },

        "lib/jquery.slimscroll.min":{
            deps: ['jquery','css!../../css/jquery-ui-1.10.3.full.min'],
            exports: ""
        }
    }
});

/**
 * Created by lohas on 2015/3/27.
 * https://github.com/lohasle
 */

/*! Sea.js 2.3.0 | seajs.org/LICENSE.md */
!function(a,b){function c(a){return function(b){return{}.toString.call(b)=="[object "+a+"]"}}function d(){return z++}function e(a){return a.match(C)[0]}function f(a){for(a=a.replace(D,"/"),a=a.replace(F,"$1/");a.match(E);)a=a.replace(E,"/");return a}function g(a){var b=a.length-1,c=a.charAt(b);return"#"===c?a.substring(0,b):".js"===a.substring(b-2)||a.indexOf("?")>0||"/"===c?a:a+".js"}function h(a){var b=u.alias;return b&&w(b[a])?b[a]:a}function i(a){var b=u.paths,c;return b&&(c=a.match(G))&&w(b[c[1]])&&(a=b[c[1]]+c[2]),a}function j(a){var b=u.vars;return b&&a.indexOf("{")>-1&&(a=a.replace(H,function(a,c){return w(b[c])?b[c]:a})),a}function k(a){var b=u.map,c=a;if(b)for(var d=0,e=b.length;e>d;d++){var f=b[d];if(c=y(f)?f(a)||a:a.replace(f[0],f[1]),c!==a)break}return c}function l(a,b){var c,d=a.charAt(0);if(I.test(a))c=a;else if("."===d)c=f((b?e(b):u.cwd)+a);else if("/"===d){var g=u.cwd.match(J);c=g?g[0]+a.substring(1):a}else c=u.base+a;return 0===c.indexOf("//")&&(c=location.protocol+c),c}function m(a,b){if(!a)return"";a=h(a),a=i(a),a=j(a),a=g(a);var c=l(a,b);return c=k(c)}function n(a){return a.hasAttribute?a.src:a.getAttribute("src",4)}function o(a,b,c){var d=K.createElement("script");if(c){var e=y(c)?c(a):c;e&&(d.charset=e)}p(d,b,a),d.async=!0,d.src=a,R=d,Q?P.insertBefore(d,Q):P.appendChild(d),R=null}function p(a,b,c){function d(){a.onload=a.onerror=a.onreadystatechange=null,u.debug||P.removeChild(a),a=null,b()}var e="onload"in a;e?(a.onload=d,a.onerror=function(){B("error",{uri:c,node:a}),d()}):a.onreadystatechange=function(){/loaded|complete/.test(a.readyState)&&d()}}function q(){if(R)return R;if(S&&"interactive"===S.readyState)return S;for(var a=P.getElementsByTagName("script"),b=a.length-1;b>=0;b--){var c=a[b];if("interactive"===c.readyState)return S=c}}function r(a){var b=[];return a.replace(U,"").replace(T,function(a,c,d){d&&b.push(d)}),b}function s(a,b){this.uri=a,this.dependencies=b||[],this.exports=null,this.status=0,this._waitings={},this._remain=0}if(!a.seajs){var t=a.seajs={version:"2.3.0"},u=t.data={},v=c("Object"),w=c("String"),x=Array.isArray||c("Array"),y=c("Function"),z=0,A=u.events={};t.on=function(a,b){var c=A[a]||(A[a]=[]);return c.push(b),t},t.off=function(a,b){if(!a&&!b)return A=u.events={},t;var c=A[a];if(c)if(b)for(var d=c.length-1;d>=0;d--)c[d]===b&&c.splice(d,1);else delete A[a];return t};var B=t.emit=function(a,b){var c=A[a],d;if(c){c=c.slice();for(var e=0,f=c.length;f>e;e++)c[e](b)}return t},C=/[^?#]*\//,D=/\/\.\//g,E=/\/[^/]+\/\.\.\//,F=/([^:/])\/+\//g,G=/^([^/:]+)(\/.+)$/,H=/{([^{]+)}/g,I=/^\/\/.|:\//,J=/^.*?\/\/.*?\//,K=document,L=location.href&&0!==location.href.indexOf("about:")?e(location.href):"",M=K.scripts,N=K.getElementById("seajsnode")||M[M.length-1],O=e(n(N)||L);t.resolve=m;var P=K.head||K.getElementsByTagName("head")[0]||K.documentElement,Q=P.getElementsByTagName("base")[0],R,S;t.request=o;var T=/"(?:\\"|[^"])*"|'(?:\\'|[^'])*'|\/\*[\S\s]*?\*\/|\/(?:\\\/|[^\/\r\n])+\/(?=[^\/])|\/\/.*|\.\s*require|(?:^|[^$])\brequire\s*\(\s*(["'])(.+?)\1\s*\)/g,U=/\\\\/g,V=t.cache={},W,X={},Y={},Z={},$=s.STATUS={FETCHING:1,SAVED:2,LOADING:3,LOADED:4,EXECUTING:5,EXECUTED:6};s.prototype.resolve=function(){for(var a=this,b=a.dependencies,c=[],d=0,e=b.length;e>d;d++)c[d]=s.resolve(b[d],a.uri);return c},s.prototype.load=function(){var a=this;if(!(a.status>=$.LOADING)){a.status=$.LOADING;var c=a.resolve();B("load",c);for(var d=a._remain=c.length,e,f=0;d>f;f++)e=s.get(c[f]),e.status<$.LOADED?e._waitings[a.uri]=(e._waitings[a.uri]||0)+1:a._remain--;if(0===a._remain)return a.onload(),b;var g={};for(f=0;d>f;f++)e=V[c[f]],e.status<$.FETCHING?e.fetch(g):e.status===$.SAVED&&e.load();for(var h in g)g.hasOwnProperty(h)&&g[h]()}},s.prototype.onload=function(){var a=this;a.status=$.LOADED,a.callback&&a.callback();var b=a._waitings,c,d;for(c in b)b.hasOwnProperty(c)&&(d=V[c],d._remain-=b[c],0===d._remain&&d.onload());delete a._waitings,delete a._remain},s.prototype.fetch=function(a){function c(){t.request(g.requestUri,g.onRequest,g.charset)}function d(){delete X[h],Y[h]=!0,W&&(s.save(f,W),W=null);var a,b=Z[h];for(delete Z[h];a=b.shift();)a.load()}var e=this,f=e.uri;e.status=$.FETCHING;var g={uri:f};B("fetch",g);var h=g.requestUri||f;return!h||Y[h]?(e.load(),b):X[h]?(Z[h].push(e),b):(X[h]=!0,Z[h]=[e],B("request",g={uri:f,requestUri:h,onRequest:d,charset:u.charset}),g.requested||(a?a[g.requestUri]=c:c()),b)},s.prototype.exec=function(){function a(b){return s.get(a.resolve(b)).exec()}var c=this;if(c.status>=$.EXECUTING)return c.exports;c.status=$.EXECUTING;var e=c.uri;a.resolve=function(a){return s.resolve(a,e)},a.async=function(b,c){return s.use(b,c,e+"_async_"+d()),a};var f=c.factory,g=y(f)?f(a,c.exports={},c):f;return g===b&&(g=c.exports),delete c.factory,c.exports=g,c.status=$.EXECUTED,B("exec",c),g},s.resolve=function(a,b){var c={id:a,refUri:b};return B("resolve",c),c.uri||t.resolve(c.id,b)},s.define=function(a,c,d){var e=arguments.length;1===e?(d=a,a=b):2===e&&(d=c,x(a)?(c=a,a=b):c=b),!x(c)&&y(d)&&(c=r(""+d));var f={id:a,uri:s.resolve(a),deps:c,factory:d};if(!f.uri&&K.attachEvent){var g=q();g&&(f.uri=g.src)}B("define",f),f.uri?s.save(f.uri,f):W=f},s.save=function(a,b){var c=s.get(a);c.status<$.SAVED&&(c.id=b.id||a,c.dependencies=b.deps||[],c.factory=b.factory,c.status=$.SAVED,B("save",c))},s.get=function(a,b){return V[a]||(V[a]=new s(a,b))},s.use=function(b,c,d){var e=s.get(d,x(b)?b:[b]);e.callback=function(){for(var b=[],d=e.resolve(),f=0,g=d.length;g>f;f++)b[f]=V[d[f]].exec();c&&c.apply(a,b),delete e.callback},e.load()},t.use=function(a,b){return s.use(a,b,u.cwd+"_use_"+d()),t},s.define.cmd={},a.define=s.define,t.Module=s,u.fetchedList=Y,u.cid=d,t.require=function(a){var b=s.get(s.resolve(a));return b.status<$.EXECUTING&&(b.onload(),b.exec()),b.exports},u.base=O,u.dir=O,u.cwd=L,u.charset="utf-8",t.config=function(a){for(var b in a){var c=a[b],d=u[b];if(d&&v(d))for(var e in c)d[e]=c[e];else x(d)?c=d.concat(c):"base"===b&&("/"!==c.slice(-1)&&(c+="/"),c=l(c)),u[b]=c}return B("config",a),t}}}(this);

/*! Sea.js css 2.3.0 | seajs.org/LICENSE.md */
!function(){function a(a){return function(b){return{}.toString.call(b)=="[object "+a+"]"}}function b(a){return"[object Function]"=={}.toString.call(a)}function c(a,c,e){var f=u.test(a),g=r.createElement(f?"link":"script");if(e){var h=b(e)?e(a):e;h&&(g.charset=h)}d(g,c,f,a),f?(g.rel="stylesheet",g.href=a):(g.async=!0,g.src=a),p=g,t?s.insertBefore(g,t):s.appendChild(g),p=null}function d(a,b,c,d){function f(){a.onload=a.onerror=a.onreadystatechange=null,c||seajs.data.debug||s.removeChild(a),a=null,b()}var g="onload"in a;return!c||!v&&g?(g?(a.onload=f,a.onerror=function(){seajs.emit("error",{uri:d,node:a}),f()}):a.onreadystatechange=function(){/loaded|complete/.test(a.readyState)&&f()},void 0):(setTimeout(function(){e(a,b)},1),void 0)}function e(a,b){var c,d=a.sheet;if(v)d&&(c=!0);else if(d)try{d.cssRules&&(c=!0)}catch(f){"NS_ERROR_DOM_SECURITY_ERR"===f.name&&(c=!0)}setTimeout(function(){c?b():e(a,b)},20)}function f(a){return a.match(x)[0]}function g(a){for(a=a.replace(y,"/"),a=a.replace(A,"$1/");a.match(z);)a=a.replace(z,"/");return a}function h(a){var b=a.length-1,c=a.charAt(b);return"#"===c?a.substring(0,b):".js"===a.substring(b-2)||a.indexOf("?")>0||".css"===a.substring(b-3)||"/"===c?a:a+".js"}function i(a){var b=w.alias;return b&&q(b[a])?b[a]:a}function j(a){var b,c=w.paths;return c&&(b=a.match(B))&&q(c[b[1]])&&(a=c[b[1]]+b[2]),a}function k(a){var b=w.vars;return b&&a.indexOf("{")>-1&&(a=a.replace(C,function(a,c){return q(b[c])?b[c]:a})),a}function l(a){var c=w.map,d=a;if(c)for(var e=0,f=c.length;f>e;e++){var g=c[e];if(d=b(g)?g(a)||a:a.replace(g[0],g[1]),d!==a)break}return d}function m(a,b){var c,d=a.charAt(0);if(D.test(a))c=a;else if("."===d)c=g((b?f(b):w.cwd)+a);else if("/"===d){var e=w.cwd.match(E);c=e?e[0]+a.substring(1):a}else c=w.base+a;return 0===c.indexOf("//")&&(c=location.protocol+c),c}function n(a,b){if(!a)return"";a=i(a),a=j(a),a=k(a),a=h(a);var c=m(a,b);return c=l(c)}function o(a){return a.hasAttribute?a.src:a.getAttribute("src",4)}var p,q=a("String"),r=document,s=r.head||r.getElementsByTagName("head")[0]||r.documentElement,t=s.getElementsByTagName("base")[0],u=/\.css(?:\?|$)/i,v=+navigator.userAgent.replace(/.*(?:AppleWebKit|AndroidWebKit)\/?(\d+).*/i,"$1")<536;seajs.request=c;var w=seajs.data,x=/[^?#]*\//,y=/\/\.\//g,z=/\/[^/]+\/\.\.\//,A=/([^:/])\/+\//g,B=/^([^/:]+)(\/.+)$/,C=/{([^{]+)}/g,D=/^\/\/.|:\//,E=/^.*?\/\/.*?\//,r=document,F=location.href&&0!==location.href.indexOf("about:")?f(location.href):"",G=r.scripts,H=r.getElementById("seajsnode")||G[G.length-1];f(o(H)||F),seajs.resolve=n,define("seajs/seajs-css/1.0.4/seajs-css",[],{})}();

/**
 * prototype ext
 */
;(function(){

    Array.prototype.indexOf = function(val) {
        for (var i = 0; i < this.length; i++) {
            if (this[i] == val) return i;
        }
        return -1;
    };

    Array.prototype.remove = function(val) {
        var index = this.indexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };

    /**
     * [format 日期格式化]
     * @param  {[type]} format ["YYYY年MM月dd日hh小时mm分ss秒"]
     * @return {[type]}        [string]
     */
    Date.prototype.format = function(format){
        var o = {
            "M+" : this.getMonth()+1, //month
            "d+" : this.getDate(), //day
            "h+" : this.getHours(), //hour
            "m+" : this.getMinutes(), //minute
            "s+" : this.getSeconds(), //second
            "q+" : Math.floor((this.getMonth()+3)/3), //quarter
            "S" : this.getMilliseconds() //millisecond
        }
        if(/(y+)/.test(format))
            format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)
            if(new RegExp("("+ k +")").test(format))
                format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
        return format;
    };

    /**
     * [ago 多少小时前、多少分钟前、多少秒前]
     * @return {[type]} [string]
     */
    Date.prototype.ago = function(){
        if(!arguments.length) return '';
        var arg = arguments,
            now=this.getTime(),
            past =  !isNaN(arg[0])?arg[0]:new Date(arg[0]).getTime(),
            diffValue = now - past,
            result='',
            minute = 1000 * 60,
            hour = minute * 60,
            day = hour * 24,
            halfamonth = day * 15,
            month = day * 30,
            year = month * 12,

            _year = diffValue/year,
            _month =diffValue/month,
            _week =diffValue/(7*day),
            _day =diffValue/day,
            _hour =diffValue/hour,
            _min =diffValue/minute;

        if(_year>=1) result=parseInt(_year) + "年前";
        else if(_month>=1) result=parseInt(_month) + "个月前";
        else if(_week>=1) result=parseInt(_week) + "周前";
        else if(_day>=1) result=parseInt(_day) +"天前";
        else if(_hour>=1) result=parseInt(_hour) +"个小时前";
        else if(_min>=1) result=parseInt(_min) +"分钟前";
        else result="刚刚";
        return result;
    }
}());

/**
 * windows ext function
 */
;(function(window){
    /**
     * yyyy-mm-dd hh:MM:ss 转成js 日期
     * @param dateStr
     * @returns {d}
     */
    function getDate(dateStr){
        var data = dateStr;
        var reCat = /(\d{1,4})/gm;
        var t = data.match(reCat);
        t[1] = t[1] - 1;
        var d = new Date(t.join(','));
        return d;
    }
    window.getDate = getDate;
}(window));


/*! layer mobile-v1.5 弹层组件移动版 License LGPL http://sentsin.com/layui/layer/  modify https://github.com/lohas/layer */
!function(a){var b="";var c=document,d="querySelectorAll",e="getElementsByClassName",f=function(a){return c[d](a)};var g={type:0,shade:!0,shadeClose:!0,fixed:!0,anim:!0};a.ready={extend:function(a){var b=JSON.parse(JSON.stringify(g));for(var c in a){b[c]=a[c]}return b},timer:{},end:{}};var h=0,i=["layermbox"],j=function(a){var b=this;b.config=ready.extend(a),b.view()};j.prototype.view=function(){var a=this,b=a.config,d=c.createElement("div");a.id=d.id=i[0]+h,d.setAttribute("class",i[0]+" "+i[0]+(b.type||0)),d.setAttribute("index",h);var g=function(){var a="object"==typeof b.title;return b.title?'<h3 style="'+(a?b.title[1]:"")+'">'+(a?b.title[0]:b.title)+'</h3><button class="layermend"></button>':""}(),j=function(){var a,c=(b.btn||[]).length;return 0!==c&&b.btn?(a='<span type="1">'+b.btn[0]+"</span>",2===c&&(a='<span type="0">'+b.btn[1]+"</span>"+a),'<div class="layermbtn">'+a+"</div>"):""}();if(b.fixed||(b.top=b.hasOwnProperty("top")?b.top:100,b.style=b.style||"",b.style+=" top:"+(c.body.scrollTop+b.top)+"px"),2===b.type&&(b.content='<i></i><i class="laymloadtwo"></i><i></i><div>'+(b.content||"")+"</div>"),d.innerHTML=(b.shade?"<div "+("string"==typeof b.shade?'style="'+b.shade+'"':"")+' class="laymshade"></div>':"")+'<div class="layermmain" '+(b.fixed?"":'style="position:static;"')+'><div class="section"><div class="layermchild '+(b.className?b.className:"")+" "+(b.type||b.shade?"":"layermborder ")+(b.anim?"layermanim":"")+'" '+(b.style?'style="'+b.style+'"':"")+">"+g+'<div class="layermcont">'+b.content+"</div>"+j+"</div></div></div>",!b.type||2===b.type){var l=c[e](i[0]+b.type),m=l.length;m>=1&&k.close(l[0].getAttribute("index"))}document.body.appendChild(d);var n=a.elem=f("#"+a.id)[0];setTimeout(function(){try{n.className=n.className+" layermshow"}catch(a){return}b.success&&b.success(n)},1),a.index=h++,a.action(b,n)},j.prototype.action=function(a,b){var c=this;if(a.time&&(ready.timer[c.index]=setTimeout(function(){k.close(c.index)},1000*a.time)),a.title&&(b[e]("layermend")[0].onclick=function(){a.cancel&&a.cancel(),k.close(c.index)}),a.btn){for(var d=b[e]("layermbtn")[0].children,f=d.length,g=0;f>g;g++){d[g].onclick=function(){var b=this.getAttribute("type");0==b?(a.no&&a.no(),k.close(c.index)):a.yes?a.yes(c.index):k.close(c.index)}}}if(a.shade&&a.shadeClose){var h=b[e]("laymshade")[0];h.onclick=function(){k.close(c.index,a.end)},h.ontouchmove=function(){k.close(c.index,a.end)}}a.end&&(ready.end[c.index]=a.end)};var k={v:"1.5",index:h,open:function(a){var b=new j(a||{});return b.index},close:function(a){var b=f("#"+i[0]+a)[0];b&&(b.innerHTML="",c.body.removeChild(b),clearTimeout(ready.timer[a]),delete ready.timer[a],"function"==typeof ready.end[a]&&ready.end[a](),delete ready.end[a])},closeAll:function(){for(var a=c[e](i[0]),b=0,d=a.length;d>b;b++){k.close(0|a[0].getAttribute("index"))}}};a.layer=k}(window);

/**
 * seajs config and mobile model
 */
;(function(){
    /**
     * seajs config
     */
    seajs.config({
        alias: {
            "jquery": "lib/jquery-1.11.1.min",
            "mmenu": "lib/jquery.mmenu.min.all",
            "template": "lib/template",
            "jquery.lazyload": "lib/jquery.lazyload",
            "jquery.swipebox": "lib/jquery.swipebox",
            "photoswipe": "lib/photoswipe.min",
            "photoswipe-ui": "lib/photoswipe-ui-default.min",
            "jquery-unslider": "lib/jquery.unslider",
            "photoSlider": "lib/photoSlider.min",
            "jweixin": "lib/jweixin-1.0.0",
            "pingpp_pay": "lib/pingpp_pay"
        },
        paths: {
            lib: window.EVA.SERV_ROOT_DIR + "/static/js/lib"
        },
        vars: {
            SERV_ROOT_DIR: window.EVA.SERV_ROOT_DIR
        },
        map: [
            [/^(.*\.(?:css|js))(.*)$/i, "$1?version=" + window.EVA.VERSION]
        ],
        preload: ["jquery"],
        charset: "utf-8"
    });

    //main
    define('mobile', ['jquery','template'], function (require) {
        var jQuery = require('jquery');
        var template = require('template');
        window.template = template;

        /**
         * 手机判断
         */
        window.browser = {
            versions: function () {
                var u = navigator.userAgent, app = navigator.appVersion;
                return {
                    trident: u.indexOf('Trident') > -1, //IE内核
                    presto: u.indexOf('Presto') > -1, //opera内核
                    webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
                    gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1,//火狐内核
                    mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端
                    ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
                    android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
                    iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者QQHD浏览器
                    iPad: u.indexOf('iPad') > -1, //是否iPad
                    webApp: u.indexOf('Safari') == -1, //是否web应该程序，没有头部与底部
                    weixin: u.indexOf('MicroMessenger') > -1, //是否微信 （2015-01-22新增）
                    qq: u.match(/\sQQ/i) == " qq" //是否QQ
                };
            }(),
            language: (navigator.browserLanguage || navigator.language).toLowerCase()
        };


        /**
         * simple loading 组件  提供层级别 Loading 默认初始化时  会加载loading
         */
        ;
        (function ($, window) {
            $.simpleloading = function (ops) {
                /* var _ops = $.extend({},{
                 },ops), ;
                 */
                var self = this;

                // 检测
                var $mark = self.find(".markbg"),
                    $loading = self.find(".loading");

                //创建元素
                if ($loading.length == 0) {
                    self.append("<div class='loading' style='display: none;'><div class='loadinggif'></div></div>");
                    $loading = self.find(".loading");//刷新
                }
                if ($mark.length == 0) {
                    self.append("<div class='markbg' style='display: none;'></div>");
                    $mark = self.find(".markbg");//刷新
                }

                //打开Loading
                self.open = function () {
                    $mark.show();
                    $loading.show();
                };

                //关闭loading
                self.close = function () {
                    setTimeout(function(){
                        $loading.hide();
                        $mark.fadeOut();
                    },100);
                };

                //清除loading
                self.clean = function () {
                    $loading.remove();
                    $mark.remove();
                };
                //检测loading
                self.isLoading=function(){
                    return !$mark.is(":hidden");
                };
                //call
                if (ops && ops != '') {
                    self[ops]();
                }

                return self;
            };
            $.fn.simpleloading = function (ops) {
                return this.each(function () {
                    $.simpleloading.call($(this), ops);
                });
            }
        })(jQuery, window);

        /**
         * jQuery MD5 hash algorithm function
         *
         *  <code>
         *      Calculate the md5 hash of a String
         *      String $.md5 ( String str )
         *  </code>
         *
         * Calculates the MD5 hash of str using the » RSA Data Security, Inc. MD5 Message-Digest Algorithm, and returns that hash.
         * MD5 (Message-Digest algorithm 5) is a widely-used cryptographic hash function with a 128-bit hash value. MD5 has been employed in a wide variety of security applications, and is also commonly used to check the integrity of data. The generated hash is also non-reversable. Data cannot be retrieved from the message digest, the digest uniquely identifies the data.
         * MD5 was developed by Professor Ronald L. Rivest in 1994. Its 128 bit (16 byte) message digest makes it a faster implementation than SHA-1.
         * This script is used to process a variable length message into a fixed-length output of 128 bits using the MD5 algorithm. It is fully compatible with UTF-8 encoding. It is very useful when u want to transfer encrypted passwords over the internet. If you plan using UTF-8 encoding in your project don't forget to set the page encoding to UTF-8 (Content-Type meta tag).
         * This function orginally get from the WebToolkit and rewrite for using as the jQuery plugin.
         *
         * Example
         *  Code
         *      <code>
         *          $.md5("I'm Persian.");
         *      </code>
         *  Result
         *      <code>
         *          "b8c901d0f02223f9761016cfff9d68df"
         *      </code>
         */

        (function($){

            var rotateLeft = function(lValue, iShiftBits) {
                return (lValue << iShiftBits) | (lValue >>> (32 - iShiftBits));
            }

            var addUnsigned = function(lX, lY) {
                var lX4, lY4, lX8, lY8, lResult;
                lX8 = (lX & 0x80000000);
                lY8 = (lY & 0x80000000);
                lX4 = (lX & 0x40000000);
                lY4 = (lY & 0x40000000);
                lResult = (lX & 0x3FFFFFFF) + (lY & 0x3FFFFFFF);
                if (lX4 & lY4) return (lResult ^ 0x80000000 ^ lX8 ^ lY8);
                if (lX4 | lY4) {
                    if (lResult & 0x40000000) return (lResult ^ 0xC0000000 ^ lX8 ^ lY8);
                    else return (lResult ^ 0x40000000 ^ lX8 ^ lY8);
                } else {
                    return (lResult ^ lX8 ^ lY8);
                }
            }

            var F = function(x, y, z) {
                return (x & y) | ((~ x) & z);
            }

            var G = function(x, y, z) {
                return (x & z) | (y & (~ z));
            }

            var H = function(x, y, z) {
                return (x ^ y ^ z);
            }

            var I = function(x, y, z) {
                return (y ^ (x | (~ z)));
            }

            var FF = function(a, b, c, d, x, s, ac) {
                a = addUnsigned(a, addUnsigned(addUnsigned(F(b, c, d), x), ac));
                return addUnsigned(rotateLeft(a, s), b);
            };

            var GG = function(a, b, c, d, x, s, ac) {
                a = addUnsigned(a, addUnsigned(addUnsigned(G(b, c, d), x), ac));
                return addUnsigned(rotateLeft(a, s), b);
            };

            var HH = function(a, b, c, d, x, s, ac) {
                a = addUnsigned(a, addUnsigned(addUnsigned(H(b, c, d), x), ac));
                return addUnsigned(rotateLeft(a, s), b);
            };

            var II = function(a, b, c, d, x, s, ac) {
                a = addUnsigned(a, addUnsigned(addUnsigned(I(b, c, d), x), ac));
                return addUnsigned(rotateLeft(a, s), b);
            };

            var convertToWordArray = function(string) {
                var lWordCount;
                var lMessageLength = string.length;
                var lNumberOfWordsTempOne = lMessageLength + 8;
                var lNumberOfWordsTempTwo = (lNumberOfWordsTempOne - (lNumberOfWordsTempOne % 64)) / 64;
                var lNumberOfWords = (lNumberOfWordsTempTwo + 1) * 16;
                var lWordArray = Array(lNumberOfWords - 1);
                var lBytePosition = 0;
                var lByteCount = 0;
                while (lByteCount < lMessageLength) {
                    lWordCount = (lByteCount - (lByteCount % 4)) / 4;
                    lBytePosition = (lByteCount % 4) * 8;
                    lWordArray[lWordCount] = (lWordArray[lWordCount] | (string.charCodeAt(lByteCount) << lBytePosition));
                    lByteCount++;
                }
                lWordCount = (lByteCount - (lByteCount % 4)) / 4;
                lBytePosition = (lByteCount % 4) * 8;
                lWordArray[lWordCount] = lWordArray[lWordCount] | (0x80 << lBytePosition);
                lWordArray[lNumberOfWords - 2] = lMessageLength << 3;
                lWordArray[lNumberOfWords - 1] = lMessageLength >>> 29;
                return lWordArray;
            };

            var wordToHex = function(lValue) {
                var WordToHexValue = "", WordToHexValueTemp = "", lByte, lCount;
                for (lCount = 0; lCount <= 3; lCount++) {
                    lByte = (lValue >>> (lCount * 8)) & 255;
                    WordToHexValueTemp = "0" + lByte.toString(16);
                    WordToHexValue = WordToHexValue + WordToHexValueTemp.substr(WordToHexValueTemp.length - 2, 2);
                }
                return WordToHexValue;
            };

            var uTF8Encode = function(string) {
                string = string.replace(/\x0d\x0a/g, "\x0a");
                var output = "";
                for (var n = 0; n < string.length; n++) {
                    var c = string.charCodeAt(n);
                    if (c < 128) {
                        output += String.fromCharCode(c);
                    } else if ((c > 127) && (c < 2048)) {
                        output += String.fromCharCode((c >> 6) | 192);
                        output += String.fromCharCode((c & 63) | 128);
                    } else {
                        output += String.fromCharCode((c >> 12) | 224);
                        output += String.fromCharCode(((c >> 6) & 63) | 128);
                        output += String.fromCharCode((c & 63) | 128);
                    }
                }
                return output;
            };

            $.extend({
                md5: function(string) {
                    var x = Array();
                    var k, AA, BB, CC, DD, a, b, c, d;
                    var S11=7, S12=12, S13=17, S14=22;
                    var S21=5, S22=9 , S23=14, S24=20;
                    var S31=4, S32=11, S33=16, S34=23;
                    var S41=6, S42=10, S43=15, S44=21;
                    string = uTF8Encode(string);
                    x = convertToWordArray(string);
                    a = 0x67452301; b = 0xEFCDAB89; c = 0x98BADCFE; d = 0x10325476;
                    for (k = 0; k < x.length; k += 16) {
                        AA = a; BB = b; CC = c; DD = d;
                        a = FF(a, b, c, d, x[k+0],  S11, 0xD76AA478);
                        d = FF(d, a, b, c, x[k+1],  S12, 0xE8C7B756);
                        c = FF(c, d, a, b, x[k+2],  S13, 0x242070DB);
                        b = FF(b, c, d, a, x[k+3],  S14, 0xC1BDCEEE);
                        a = FF(a, b, c, d, x[k+4],  S11, 0xF57C0FAF);
                        d = FF(d, a, b, c, x[k+5],  S12, 0x4787C62A);
                        c = FF(c, d, a, b, x[k+6],  S13, 0xA8304613);
                        b = FF(b, c, d, a, x[k+7],  S14, 0xFD469501);
                        a = FF(a, b, c, d, x[k+8],  S11, 0x698098D8);
                        d = FF(d, a, b, c, x[k+9],  S12, 0x8B44F7AF);
                        c = FF(c, d, a, b, x[k+10], S13, 0xFFFF5BB1);
                        b = FF(b, c, d, a, x[k+11], S14, 0x895CD7BE);
                        a = FF(a, b, c, d, x[k+12], S11, 0x6B901122);
                        d = FF(d, a, b, c, x[k+13], S12, 0xFD987193);
                        c = FF(c, d, a, b, x[k+14], S13, 0xA679438E);
                        b = FF(b, c, d, a, x[k+15], S14, 0x49B40821);
                        a = GG(a, b, c, d, x[k+1],  S21, 0xF61E2562);
                        d = GG(d, a, b, c, x[k+6],  S22, 0xC040B340);
                        c = GG(c, d, a, b, x[k+11], S23, 0x265E5A51);
                        b = GG(b, c, d, a, x[k+0],  S24, 0xE9B6C7AA);
                        a = GG(a, b, c, d, x[k+5],  S21, 0xD62F105D);
                        d = GG(d, a, b, c, x[k+10], S22, 0x2441453);
                        c = GG(c, d, a, b, x[k+15], S23, 0xD8A1E681);
                        b = GG(b, c, d, a, x[k+4],  S24, 0xE7D3FBC8);
                        a = GG(a, b, c, d, x[k+9],  S21, 0x21E1CDE6);
                        d = GG(d, a, b, c, x[k+14], S22, 0xC33707D6);
                        c = GG(c, d, a, b, x[k+3],  S23, 0xF4D50D87);
                        b = GG(b, c, d, a, x[k+8],  S24, 0x455A14ED);
                        a = GG(a, b, c, d, x[k+13], S21, 0xA9E3E905);
                        d = GG(d, a, b, c, x[k+2],  S22, 0xFCEFA3F8);
                        c = GG(c, d, a, b, x[k+7],  S23, 0x676F02D9);
                        b = GG(b, c, d, a, x[k+12], S24, 0x8D2A4C8A);
                        a = HH(a, b, c, d, x[k+5],  S31, 0xFFFA3942);
                        d = HH(d, a, b, c, x[k+8],  S32, 0x8771F681);
                        c = HH(c, d, a, b, x[k+11], S33, 0x6D9D6122);
                        b = HH(b, c, d, a, x[k+14], S34, 0xFDE5380C);
                        a = HH(a, b, c, d, x[k+1],  S31, 0xA4BEEA44);
                        d = HH(d, a, b, c, x[k+4],  S32, 0x4BDECFA9);
                        c = HH(c, d, a, b, x[k+7],  S33, 0xF6BB4B60);
                        b = HH(b, c, d, a, x[k+10], S34, 0xBEBFBC70);
                        a = HH(a, b, c, d, x[k+13], S31, 0x289B7EC6);
                        d = HH(d, a, b, c, x[k+0],  S32, 0xEAA127FA);
                        c = HH(c, d, a, b, x[k+3],  S33, 0xD4EF3085);
                        b = HH(b, c, d, a, x[k+6],  S34, 0x4881D05);
                        a = HH(a, b, c, d, x[k+9],  S31, 0xD9D4D039);
                        d = HH(d, a, b, c, x[k+12], S32, 0xE6DB99E5);
                        c = HH(c, d, a, b, x[k+15], S33, 0x1FA27CF8);
                        b = HH(b, c, d, a, x[k+2],  S34, 0xC4AC5665);
                        a = II(a, b, c, d, x[k+0],  S41, 0xF4292244);
                        d = II(d, a, b, c, x[k+7],  S42, 0x432AFF97);
                        c = II(c, d, a, b, x[k+14], S43, 0xAB9423A7);
                        b = II(b, c, d, a, x[k+5],  S44, 0xFC93A039);
                        a = II(a, b, c, d, x[k+12], S41, 0x655B59C3);
                        d = II(d, a, b, c, x[k+3],  S42, 0x8F0CCC92);
                        c = II(c, d, a, b, x[k+10], S43, 0xFFEFF47D);
                        b = II(b, c, d, a, x[k+1],  S44, 0x85845DD1);
                        a = II(a, b, c, d, x[k+8],  S41, 0x6FA87E4F);
                        d = II(d, a, b, c, x[k+15], S42, 0xFE2CE6E0);
                        c = II(c, d, a, b, x[k+6],  S43, 0xA3014314);
                        b = II(b, c, d, a, x[k+13], S44, 0x4E0811A1);
                        a = II(a, b, c, d, x[k+4],  S41, 0xF7537E82);
                        d = II(d, a, b, c, x[k+11], S42, 0xBD3AF235);
                        c = II(c, d, a, b, x[k+2],  S43, 0x2AD7D2BB);
                        b = II(b, c, d, a, x[k+9],  S44, 0xEB86D391);
                        a = addUnsigned(a, AA);
                        b = addUnsigned(b, BB);
                        c = addUnsigned(c, CC);
                        d = addUnsigned(d, DD);
                    }
                    var tempValue = wordToHex(a) + wordToHex(b) + wordToHex(c) + wordToHex(d);
                    return tempValue.toLowerCase();
                }
            });
        })(jQuery);

        /**
         * mobile  tips
         */
        (function ($, window) {
            $.mobileTip = function (ops,cb) {
                // ops  text
                /* var _ops = $.extend({},{
                 },ops), ;
                 */
                var self = this;

                // 检测
                var $tips = self.find(".bs-tips");
                //创建元素
                if ($tips.length == 0) {
                    self.append("<div class='bs-tips'><span></span></div>");
                    $tips = self.find(".bs-tips");//刷新
                }
                $tips.hide().children().html(ops);

                $tips.animate({
                    "bottom":'15%',
                    "opacity":'show'
                },300,function(){
                    setTimeout(function(){
                        $tips.fadeOut(500, function () {
                            (cb|| $.noop).call(self);
                        });
                    },1000);

                });


                return self;
            };
            $.fn.mobileTip = function (ops) {
                return this.each(function () {
                    $.mobileTip.call($(this), ops);
                });
            }
        })(jQuery, window);


        /***
         * bs https://github.com/lohas
         */
        ;(function(window){

            var _bs = {};

            _bs.revisePath = function(path){
                return path.replace(/\/{2,}/g,'\/')
            };
            _bs.noop = function(){},
            _bs.getCookie=function(name){
                var ret = new RegExp('(?:^|[^;])' + name + '=([^;]+)').exec(document.cookie);
                return ret ? decodeURIComponent(ret[1]) : '';
            };

            _bs.setCookie = function(name, value, expir){
                var cookie = name + '=' + encodeURIComponent(value);
                if(expir !== void 0){
                    var now = new Date();
                    now.setDate(now.getDate() + ~~expir);
                    cookie += '; expires=' + now.toGMTString();
                }
                document.cookie = cookie;
            };

            _bs.delCookie = function(name){
                var exp = new Date();
                exp.setTime(exp.getTime() - 1);
                var cval=_bs.getCookie(name);
                if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
            };

            /**
             * 设置缓存
             * @param name 名称
             * @param value 值
             */
            _bs.setCache = function(name,value){
                if(localStorage){
                    localStorage.setItem(name,value);
                }else if(document.cookie){
                    _bs.setCookie(name,value);
                }
            };
            /**
             * 得到缓存
             * @param cacheName
             */
            _bs.getCache = function(cacheName){
                var cacheValue = '';
                if(localStorage){
                    cacheValue = localStorage.getItem(cacheName);
                }else if(document.cookie){
                    cacheValue = _bs.getCookie(cacheName);
                }
                return cacheValue;
            };


            /**
             * 清除缓存
             * @param cacheName
             */
            _bs.cleanCache = function(cacheName){
                var cacheValue = '';
                if(localStorage){
                    cacheValue = localStorage.removeItem(cacheName);
                }else if(document.cookie){
                    cacheValue = _bs.getCookie(cacheName); //删除cookie
                    _bs.delCookie(cacheValue);
                }
                return cacheValue;
            };

            /**
             * 清除所有缓存
             * @param cacheName
             */
            _bs.cleanAllCache = function(){
                if(localStorage){
                    localStorage.clear();
                }else if(document.cookie){
                    //清空cookie
                    var keys=document.cookie.match(/[^ =;]+(?=\=)/g);
                    if (keys) {
                        for (var i = keys.length; i--;)
                            document.cookie=keys[i]+'=0;expires=' + new Date(0).toUTCString();
                    }
                }
            };

            /**真实宽高**/
            _bs.getRelSize=  function($el,method){
                var $self = $($el);
                if(method=='width'||method=='height'){
                    var size = $self.show()[method]();
                    $self.hide();
                    return size;
                }
            };
            //创建url
            _bs.createReqUrl = function(url,params){
                var s = url+'?';
                for(var key in params){
                    s+=("&"+key+"="+params[key]);
                }
                s = s.substr(0, s.length - 1);
                return s;
            };

            //创建url
            _bs.getRelHref = function(){
                return location.pathname;
            };

             _bs.isEmpty = function(val){
                return !/\S/.test(val);
            };
            _bs.is_weixn = function () {
                var ua = navigator.userAgent.toLowerCase();
                if (ua.match(/MicroMessenger/i) == "micromessenger") {
                    return true;
                } else {
                    return false;
                }
            };

            _bs.isNumber = function(val){
                return /\d+/.test(val);
            };

            _bs.isPhone = function (val) {
                if (val != '' && /^0?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$/.test(val)) {
                    return true;
                }
                return false;
            };

            // 确认框
            _bs.confirm = function(parData){
                layer.open({
                    shadeClose: false,
                    btn: parData.btn,
                    yes:function(index){
                        (parData.yes|| _bs.noop).call(this,index);
                    },
                    no:function(index){
                        (parData.no|| _bs.no).call(this,index);
                    },
                    content:parData.content,
                    style:'color:#000;min-width:200px;'
                })
            };

            //日记上报
            _bs.log = function(data,leve){
                if(console){
                    console.log(data);
                }
            };

            // wx action

            _bs.wx = {
                ready:function(wx,data,apiList,func){
                    // config
                    wx.config({
                        //debug: true,
                        appId: data.appId,
                        timestamp: data.timestamp,
                        nonceStr: data.nonceStr,
                        signature: data.signature,
                        jsApiList: apiList
                    });

                    // ready
                    wx.ready(function () {
                        (func|| $.noop).call(this,wx);
                    });

                }
            };

            // 弹窗
            _bs.alert = function(content,btn,call){
                var _btn = arguments.length==3?btn:"确定";
                var _call = arguments.length==3?call:(btn||bs.noop);
                layer.open({
                    shadeClose: false,
                    content: content,
                    btn: [_btn],
                    style:'color:#000;min-width:200px;',
                    yes:function(index){
                        _call.call(this,index);
                        layer.close(index);
                    }
                });
            };

            // 跳转
            _bs.goTo = function(href){
                //  check 是否 有父窗口
                if(window.top!=window.self){
                    //
                    var app =  bs.getCache("app");
                    if(app=="true"){
                        window.parent.goTo(href);
                    }
                }else{
                    location.href = href;
                }
            };

            // 创建一个frame closeCallBack 子窗口关闭函数
            _bs.createFullFrame = function(url,closeCallBack){
                var $iframe = $('<iframe class="frameContent" id="contentFrame" name="contentFrame" frameborder="0" src="'+url+'"></iframe>');
                var $div = $("<div class='frameWarp' id='iframeScroll'></div>");
                $div.css({
                    height:$(window).height()
                });
                $div.append($iframe);

                $(".bs-header,.bs-warp,.bs-footer").hide();

                $("body").append($div);

                window.closeCallBack = closeCallBack;//注册关闭窗口的回调
            };

            // 页面刷新
            _bs.reload = function(){
                //  check 是否 有父窗口
                if(window.top!=window.self){
                    //
                    var app =  bs.getCache("app");
                    if(app=="true"){
                        window.parent.goTo(location.href);
                    }
                }else{
                    location.reload();
                }
            };

            /**
             * 相册浏览
             */
            _bs.openImgGallery = function(imgsArr,index,w,h){
                var pswpElement = document.querySelectorAll('.pswp')[0];
                var items = [];


// build items array
                for(var i= 0,len=imgsArr.length;i<len;i++){
                    var $img = $(imgsArr[i]);
                    items.push({
                        src:$img.attr("src"),
                        w:w?w:$img.width()?$img.width():600,
                        h:h?h:$img.height()?$img.height():400
                    });
                };

// define options (if needed)
                var options = {
                    // optionName: 'option value'
                    // for example:
                    index: index // start at first slide
                };

// Initializes and opens PhotoSwipe
                var gallery = new PhotoSwipe( pswpElement, PhotoSwipeUI_Default, items, options);
                gallery.init();
            };
            window.bs= _bs;
        })(window);

// init common
        jQuery(function ($) {

            // a 地址  b 执行次数  c 延时时间  d线程数
            function testReq(a,b,c,d){
                for(var j=0;j<d;j++){
                    for(var i= 0;i<b;i++){
                        setTimeout(function(){
                            $.getJSON(a);
                        },c);
                    }
                }
            }

            var eventName = (browser.versions.mobile)?"touchstart":"click";

            //公用事件绑定
            $("body").on('click','.deving',function(){
                $("body").mobileTip("正在开发，敬请期待...");
            });
            //document.oncontextmenu=false;

             //  check 是否 有父窗口
            if(window.top!=window.self){
                //
                var app =  bs.getCache("app");
                if(app=="true"){

                    // 调用父窗口方法
                    (window.parent.appendBottom|| $.noop).call(this,$(".footer-menu")[0]);
                    $(".footer-menu").remove(); // 去除


                    var h = window.browser.versions.ios?0:0;
                    var $header = $(".bs-header");
                    var heigth = $header.height()+h;
                    $header.after("<div style='height:"+heigth+"px'></div>");
                    //(window.parent.appendTop|| $.noop).call(this,$header[0]);
                    $(".bs-header").css({
                        "position":"fixed",
                        "width":"100%",
                        "top":h,
                        "z-index":999
                    });


                    $("body").find("a").each(function(a,b){
                        var $self = $(b);
                        if($self.attr("href")&&$self.attr("href")!=""&&$self.attr("href").indexOf("javascript")==-1) {
                            $self.attr("href","javascript:window.parent.goTo('"+$self.attr("href")+"');");
                        }
                    });
                }
            }

        });

    });
}());


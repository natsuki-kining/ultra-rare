(function ($w, $vue, undefined) {
    const ur = {
        baseURL: 'http://localhost:8080/',
        success:function(data,func){
            console.log(data);
            if(func){
                func(data.data);
            }
        },
        error:function (data,func) {
            console.log(data);
            if(func){
                func(data);
            }
        },
        ajax: function (config,successFunc,errorFunc) {
            if (!config.url){
                config.url = this.baseURL + 'query';
            }
            axios(config)
            .then(function(data){
                ur.success(data,successFunc)
            })
            .catch(function (data) {
                ur.error(data,errorFunc);
            });
        },
        post: function (config,successFunc,errorFunc) {
            if (!config){
                config = {}
            }
            config.method = 'post';
            this.ajax(config,successFunc,errorFunc);
        },
        get: function (config,successFunc,errorFunc) {
            if (!config){
                config = {}
            }
            config.method = 'get';
            this.ajax(config,successFunc,errorFunc);
        },
        query:function (queryCode, params,successFunc,errorFunc) {
            if (!params){
                params = {}
            }
            params.queryCode = queryCode;
            let config = {
                data:params
            };
            this.post(config,successFunc,errorFunc);
        },
    }
    $w.ur = ur;
})(window, Vue);
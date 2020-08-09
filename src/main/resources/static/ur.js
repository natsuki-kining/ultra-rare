(function ($w, $vue, undefined) {
    const ur = {
        baseURL: 'http://localhost:8080/',
        success: function (response, func) {
            console.log(response);
            if (func) {
                func(response.data);
            }
        },
        error: function (response, func) {
            console.log(response);
            if (func) {
                func(data);
            }
        },
        /**
         * 在传递给 then/catch 前，允许修改响应数据
         * @param data
         * @returns {any}
         */
        transformResponse:function(data){
            let parse = JSON.parse(data);
            ur.keyCase(parse);
            return parse;
        },
        ajax: function (config, successFunc, errorFunc) {
            config.url = config.url || this.baseURL + 'query';
            if (!config.transformResponse){
                if (config.useTransformResponse === undefined || config.useTransformResponse){
                    config.transformResponse = ur.transformResponse;
                }
            }
            axios(config)
                .then(function (data) {
                    ur.success(data, successFunc)
                })
                .catch(function (data) {
                    ur.error(data, errorFunc);
                });
        },
        post: function (config, successFunc, errorFunc) {
            config = config || {};
            config.method = config.method || 'post';
            this.ajax(config, successFunc, errorFunc);
        },
        get: function (config, successFunc, errorFunc) {
            config = config || {};
            config.method = config.method || 'get';
            this.ajax(config, successFunc, errorFunc);
        },
        query: function (queryParam, config, successFunc, errorFunc) {
            config = config || {};
            let data = {};
            if (typeof queryParam === 'string') {
                data.queryCode = queryParam;
            } else {
                data = queryParam;
            }
            config.data = data;
            this.post(config, successFunc, errorFunc);
        },
        /**
         * 将map key转为驼峰格式
         * @param json
         */
        keyCase: function (json) {
            if (typeof json == 'object') {
                if (Array.isArray(json)) {
                    json.forEach(function (item) {
                        ur.keyCase(item);
                    })
                } else {
                    for (let key in json) {
                        let item = json[key];
                        if (typeof item == 'object') {
                            ur.keyCase(item);
                        }
                        delete (json[key]);
                        let newKey='';
                        key = key.toLocaleLowerCase();
                        for (let i = 0; i < key.length; i++) {
                            let char = key.charAt(i);
                            if (char == '_'){
                                i++;
                                char = key.charAt(i).toLocaleUpperCase();
                                newKey+=char;
                                continue;
                            }
                            newKey+=char;
                        }
                        json[newKey] = item;
                    }
                }
            }

        }
    }
    $w.ur = ur;
})(window, Vue);
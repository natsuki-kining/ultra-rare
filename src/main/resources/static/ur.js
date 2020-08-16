(function ($w, $vue, undefined) {
    const ur = {
        baseURL: 'http://localhost:8080/',
        /**
         * 
         * @param {object} response 响应数据
         * @param {function} func 请求成功回调的函数
         */
        success: function (response, func) {
            console.debug(response);
            if (func) {
                func(response.data);
            }
        },
        /**
         * 请求失败回调函数
         * @param {error}} response 
         * @param {*} func 
         */
        error: function (response, func) {
            console.error(response);
            if (func) {
                func(data);
            }
        },
        /**
         * 在传递给 then/catch 前，允许修改响应数据
         * @param data
         * @returns {any}
         */
        transformResponse: function (data) {
            let parse = JSON.parse(data);
            ur.keyCase(parse);
            return parse;
        },
        ajax: function (config, successFunc, errorFunc) {
            config.url = config.url || this.baseURL + 'query';
            config.data.queryResultModel = config.data.queryResultModel || false;
            if (!config.transformResponse) {
                config.useTransformResponse = config.useTransformResponse || false;
                if (config.useTransformResponse) {
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
            return this.ajax(config, successFunc, errorFunc);
        },
        get: function (config, successFunc, errorFunc) {
            config = config || {};
            config.method = config.method || 'get';
            return this.ajax(config, successFunc, errorFunc);
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
            return this.post(config, successFunc, errorFunc);
        },
        setQueryData: function (setting) {
            this.query(setting.queryParam||{}, setting.config||{}, (responseData)=> {
                setting.obj[setting.objKey] = responseData;
            });
        },
        setResponseData:function(obj){
            this.setQueryData({
                "queryParam": obj.setting.queryCode,
                "obj": obj,
                "objKey": obj.setting.objKey
            });
        },
        vueExtend:function(template,data,setIntervalTime){
            let ve = Vue.extend({
                template: template,
                data() {
                    return data;
                },
                methods: {
                    createData() {
                        ur.setResponseData(this);
                    }
                },
                mounted() {
                    const {createData} = this
                    createData()
                    if(setIntervalTime&&setIntervalTime>0){
                        setInterval(createData, setIntervalTime)
                    }
                }
            });
            return ve;
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
                        let newKey = '';
                        key = key.toLocaleLowerCase();
                        for (let i = 0; i < key.length; i++) {
                            let char = key.charAt(i);
                            if (char == '_') {
                                i++;
                                char = key.charAt(i).toLocaleUpperCase();
                                newKey += char;
                                continue;
                            }
                            newKey += char;
                        }
                        json[newKey] = item;
                    }
                }
            }
        }
    }
    $w.ur = ur;
})
(window, Vue);
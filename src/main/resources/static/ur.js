(function ($w, $vue, undefined) {
    const ur = {
        baseInfo: {
            baseUrl: 'https://localhost:8080/',
            baseQueryUrl: BASE_URL + 'query'
        },
        success:function(){

        },
        error:function () {
        },
        ajax: function (url, params, type) {

        },
        post: function (url, params) {
            this.ajax(url, params, 'post');
        },
        get: function (url, params) {
            Vue.$http.get('/user',{
                params:{

                }
            })
                .then(function(response){
                    console.log(response);
                })
                .catch(function(err){
                    console.log(err);
                });
        }
    }
    $w.ur = ur;
})(window, Vue);
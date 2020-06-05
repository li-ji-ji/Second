//index.js
//获取应用实例


Page({
    data: {
        title: '选择文件及上传',
        msg: '',
        page: '',
        fileName: '',
        kindPath: {}
    },

    handleGetMessage: function(e) {
        var that = this
        console.log("asfadvad vsfdb+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
        console.log(e)
        console.log(e.detail.data[0].fileName[0].fileName)
        console.log(e.detail.data[0].fileName[0].path)
            // that.setData({
            //     fileName: e.detail.data[0].fileName
            // })
            // console.log(that.data.uploadfile)
            // console.log(typeof(that.data.uploadfile))
        var pages = getCurrentPages();
        var prevPage = pages[pages.length - 2];
        console.log("_________________________________________________________-")
        var msg = {
            url: e.detail.data[0].fileName[0].path,
            name: e.detail.data[0].fileName[0].fileName
        }
        console.log(msg)
        prevPage.setData({
            uploadfile: prevPage.data.uploadfile.concat(msg),

        })


    },

    onLoad: function(options) {
        var that = this
        var test = [];
        // test = options.nowPage
        test = options.nowPage
            // that.data.kindPath = JSON.parse(decodeURIComponent(test))
            // console.log(typeof(that.data.kindPath))
        that.setData({
            page: test,
            msg: 'http://qzimp.cn/csp/wechat/upload?page=' + test
        });
        console.log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
        console.log(typeof(test))
            // that.data.msg = 'https://qzimp.cn/api/second/toUpload?page=' + test

        console.log(test)

    },



    methods: {}


})
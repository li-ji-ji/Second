//kind.js
//获取应用实例
//api√
import { $init, $digest } from '../utils/common.util'
var util = require('../../utils/util.js');

var app = getApp();
var host = app.globalData.host;


Page({
    data: {
        // title: null,
        kindId: null,
        showIntro: 'false',
        fileName: '111',
        nowScore: 'qwe',
        introIndex: '',

        kinds: [],
        sonKinds: [],
        uploadfile: [],
        images: [],
        applyMsg: null,

        windowHeight: wx.getSystemInfoSync().windowHeight,

    },
    onLoad: function(options) {
        $init(this)
        var that = this
            // console.log(options.fileName)
            //获取所点击分类的名称以及ID
        that.setData({
            title: options.nameData,
            kindId: options.idData,
            // fileName: options.fileName
        });
        // console.log(that.data.fileName)
        wx.request({
          url: host+'/applyKind/getApplyKindByPid', //仅为示例，并非真实的接口地址
            data: {
                pId: that.data.kindId
            },
            header: {
                'content-type': 'application/json' // 默认值
            },
            success(res) {
                that.setData({
                    kinds: res.data
                })
                console.log(res.data)
            }
        });
        wx.getStorage({
            //获取本地缓存      
            key: "userInfo",
            success: function(res) {
                //console.log("本地缓存")
                //console.log(res.data.sn)
                that.setData({
                    stuId: res.data.sn
                });
            },
        })

    },




    // 监听compclick事件

    onCompClick(e) {
        var that = this;
        that.setData({
            showIntro: e.detail[0],
            introIndex: e.detail[1],
            nowId: e.detail[2]
        });
        console.log('接收select组件传递的内容:', e.detail[1]);
        console.log('id:', that.data.kinds[that.data.introIndex].id);
        // '我是 select 组件' 

        wx.request({
          url: host +'/applyKind/getApplyKindByPid', //仅为示例，并非真实的接口地址
            data: {
                pId: that.data.kinds[that.data.introIndex].id
            },
            header: {
                'content-type': 'application/json' // 默认值
            },
            success(res) {
                that.setData({
                    sonKinds: res.data
                })
                console.log(res)
            }
        });
    },

    onCompClick_2(e) {
        this.setData({
            score: e.detail
        })
    },
    //跳转至web-view
    jumpWeb: function() {
        var that = this;
        var pages = getCurrentPages(); //获取当前页面栈
        // console.log("-----------------------------------------------------------")
        // console.log(pages)
        // console.log(pages.length - 1)
        // console.log(pages[1])
        // console.log("-----------------------------------------------------------")
        var curPage = pages[pages.length - 1] //获取上一页面栈
        // console.log("-----------------------------------------------------------")
        // console.log(typeof(curPage))
        // console.log("-----------------------------------------------------------")
        var nowPage = encodeURIComponent(JSON.stringify(curPage)) //先转json字符串，但因字符串过长，navigateto无法携带，需使用encodeURIComponent再次转换
        // console.log(JSON.stringify(curPage))
        // console.log(curPage)
        wx.navigateTo({
            url: '../web/web?nowPage=' + nowPage
        });
        that.setData({
            qwe: true
        })
    },

    // upload: function(e) {
    //     var that = this
    //     wx.chooseMessageFile({
    //             count: 1,
    //             type: 'all',
    //             success(res) {
    //                 const tempFilePath = res.tempFilePath
    //                     // console.log("1")
    //                     // console.log(res.tempFiles)
    //                 console.log("2")
    //                 console.log(res.tempFiles[0].path)
    //                 console.log(res.tempFiles[0].name)
    //                 console.log("3")
    //                 var msg = {
    //                     url: res.tempFiles[0].path,
    //                     name: res.tempFiles[0].name
    //                 }
    //                 console.log(msg)
    //                 that.setData({
    //                     // [msg.url]: res.tempFiles[0].path,
    //                     // [that.data.msg.name]: this.res.tempFiles[0].name,
    //                     uploadfile: that.data.uploadfile.concat(msg)
    //                 })
    //                 console.log('删除前')
    //                 console.log(that.data.uploadfile[0].name)
    //             }
    //         })
    //         // wx.getFileInfo({
    //         //     filePath:miniprogram-test-3\images,
    //         //     success(res) {
    //         //         console.log(res.size)
    //         //         console.log(res.digest)
    //         //     }
    //         // })
    // },
    //移除文件
    removefile(e) {
        var that = this;
        const idx = e.target.dataset.idx
        console.log('删除')
        console.log(idx)
        if (that.data.uploadfile.length == 1) {
            that.setData({
                uploadfile: []
            })
        } else {
            that.data.uploadfile.splice(idx, 1)
        }

        $digest(that)


    },

    // handleImagePreview(e) {
    //     var that = this
    //     const idx = parseInt(e.target.dataset.idx)
    //     console.log(parseInt(e.target.dataset.idx))

    //     // const images = this.data.images.concat(that.data.uploadfile[idx].url)

    //     console.log(images)
    //     wx.previewImage({
    //         current: images[idx], //当前预览的图片
    //         urls: images, //所有要预览的图片
    //     })
    // },
    //上传图片
    uploadImage(e) {
        wx.chooseImage({
            sizeType: ['original', 'compressed'], //可选择原图或压缩后的图片
            sourceType: ['album', 'camera'], //可选择性开放访问相册、相机
            success: res => {
                const images = this.data.images.concat(res.tempFilePaths)
                    // 限制最多只能留下3张照片
                this.data.images = images.length <= 3 ? images : images.slice(0, 3)
                this.data.applyMsg.docImgs = images
                $digest(this)
                console.log("~~~~~~~~~~~~~~~~~~~~~~~")
                console.log(this.data.images)
                console.log(this.data.applyMsg.images)
            }

        })

    },
    //移除图片
    removeImage(e) {
        const idx = e.target.dataset.idx
        this.data.images.splice(idx, 1)
        $digest(this)
    },
    //预览图片
    handleImagePreview(e) {
        const idx = e.target.dataset.idx
        const images = this.data.images
        wx.previewImage({
            current: images[idx], //当前预览的图片
            urls: images, //所有要预览的图片
        })
    },
    //获取textarea输入类容
    getContent: function(e) {
        var that = this;


        console.log('e:' + e.detail.value)
        that.setData({
            'applyMsg.docText': e.detail.value,
        })
        console.log('content:' + that.data.applyMsg.content)
    },
    //提交
    submit: function() {
      var that=this
        // 获取存储信息，判断用户是否登陆过
        wx.getStorage({
          key: 'userInfo',
          success: function (res) {
            //console.log("本地缓存")
            //console.log(res.data.sn)
            that.setData({
              stuId: res.data.sn
            })
          },
          fail(res) { //否则，进入登陆界面
            //console.log(res.data);
            wx.showToast({
              title: '未绑定用户',
            })
          }
        })
        var supportDoc = JSON.stringify(this.data.applyMsg)
        // console.log("=========================佐证材料===========================")
        // console.log(supportDoc)
        // console.log("=======================佐证材料=============================")
        var integral, kindName, kindId

        console.log(JSON.stringify(this.data.uploadfile.url))
        var applyTime = new Date();
        // console.log(typeof (kindName))
        // console.log(supportDoc)
        if (this.data.nowId == undefined) {
          wx.showToast({
            title: '无申请类别',
          })
        }
        else if (this.data.applyMsg==null){
          wx.showToast({
            title: '无佐证材料',
          })
        }
        else{
          if (this.data.sonKinds.length > 0) {
            integral = this.data.sonKinds[this.data.score].kindIntegral
            kindName = this.data.sonKinds[this.data.score].kindName
            kindId = this.data.sonKinds[this.data.score].id
          } else {
            integral = this.data.kinds[this.data.introIndex].kindIntegral
            kindName = this.data.kinds[this.data.introIndex].kindName
            kindId = this.data.kinds[this.data.introIndex].id
          }
          wx.request({
            url: host+"/apply/insertApplyOne",
            method: "POST",
            data: {
              kindId: kindId,
              kindName: kindName,
              applyTime: applyTime,
              stuId: this.data.stuId,
              supportDoc: supportDoc,
              supportFile: JSON.stringify(this.data.uploadfile).url,
              integral: integral
            },
            header: { "Content-Type": "application/JSON" },
            success: function (res) {
              // console.log(res.data);
              wx.showToast({
                title: '提交成功！返回首页',
                icon: 'success',
                duration: 2000
              })
              setTimeout(function () {
                wx.reLaunch({
                  url: '/pages/homePage/homePage'
                })
              },1000)
            },
          })
        }
    },

    methods: {

    },


})
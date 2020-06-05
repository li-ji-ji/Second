// pages/activity/activity.js
//api √
var app = getApp();
var host = app.globalData.host;
Page({

    /**
     * 页面的初始数据
     */
    data: {
        interval: 2000,
        imgUrls: [
            'http://img4.imgtn.bdimg.com/it/u=737358321,485360143&fm=26&gp=0.jpg',
            'http://img0.imgtn.bdimg.com/it/u=120152647,959978291&fm=26&gp=0.jpg',

        ],
        act: {}
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
        var that = this
        that.setData({
            title: options.nameData,
            kindId: options.idData,
            activityId: options.activityId,
            end: options.end
        });
        // console.log("that.data.end")
        // console.log(that.data.end)
        //发起请求，获取活动详情
        wx.request({
          url: host +'/AssoActivity/getActivityByActId',
          data: {
            actId: that.data.activityId,
          },
          header: {
            'content-type': 'application/json' // 默认值
          },
          success(res) {
            console.log(res.data)
            that.setData({
              act: res.data
            });
            console.log(that.data.act)
          }
        })
        wx.getStorage({
            //获取本地缓存      
            key: "userInfo",
            success: function(res) {
                // console.log("本地缓存")
                // console.log(res.data.sn)
                that.setData({
                    stuId: res.data.sn
                });
                
                    //获取学生报名情况
                wx.request({
                  url: host +'/ActStuRelation/getActStuRelationByActIdAndStuId?actId=' + that.data.activityId + '&stuId=' + that.data.stuId, //仅为示例，并非真实的接口地址
                    data: {

                    },
                    method: "get",
                    header: {
                        'content-type': 'application/json' // 默认值
                    },
                    success(res) {
                        console.log(typeof(res.data))
                        console.log("res")
                        console.log(res)
                        if (res.data[0] == undefined) {
                            that.setData({
                                joinStatus: 1
                            })
                        } else {
                            if (res.data[0].status == 0) {
                                that.setData({
                                    joinStatus: 1
                                })
                            }

                        }

                    }
                })
          }, 
          fail(res) { //否则，进入登陆界面
            //console.log(res.data);
            that.setData({
              joinStatus: 1
            })
          }
        })
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function() {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function() {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function() {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function() {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function() {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function() {

    },
    // handleImagePreview(e) {
    //     const idx = e.currentTarget.dataset.index
    //     console.log(e.currentTarget.dataset.index)
    //     const imgUrls = this.data.imgUrls
    //     console.log(typeof(imgUrls[idx]))
    //     console.log(imgUrls[idx])
    //     wx.previewImage({
    //         current: imgUrls[idx], //当前预览的图片
    //         urls: imgUrls, //所有要预览的图片
    //     })
    // },

    //报名
    join: function() {
        var that = this
        wx.getStorage({
          key: 'userInfo',
          success: function (res) {
            // console.log("本地缓存")
            // console.log(res.data)
            that.setData({
              stuId: JSON.parse(res.data).sn
            })
            wx.request({
              url: host+'/ActStuRelation/addActStuRelationOne?actId=' + that.data.activityId + '&stuId=' + that.data.stuId,                //仅为示例，并非真实的接口地址
              data: {
                // stuId: that.data.stuId,
                // activityId: that.data.activityId
              },
              header: {
                'content-type': 'application/json' // 默认值
              },
              success(res) {
                // console.log('@@@@@@@22')
                // console.log(res)
                that.setData({
                  joinStatus: res
                })
                wx.showToast({
                  title: '报名成功!',
                  icon: "success"
                })
              }
            })
          },
          fail(res) { //否则，进入登陆界面
            //console.log(res.data);
            wx.showToast({
              title: '未绑定用户',
            })
          }
        })
    },
    //取消报名
    delateJoin: function() {
        var that = this
        wx.getStorage({
          key: 'userInfo',
          success: function (res) {
            //console.log("本地缓存")
            //console.log(res.data.sn)
            that.setData({
              stuId: res.data.sn
            })
            wx.request({
              url: host+'/ActStuRelation/setActStuRelationOneStatusCancel?actId=' + that.data.activityId + '&stuId=' + that.data.stuId,
              data: {
                // stuId: that.data.stuId,
                // activityId: that.data.activityId
              },
              header: {
                'content-type': 'application/json' // 默认值
              },
              success(res) {
                // console.log('取消报名')
                // console.log(res)
                if (res.data == 1) {
                  that.setData({
                    joinStatus: 1
                  })
                }

                wx.showToast({
                  title: '取消报名成功!',
                  icon: "success"
                })
              }
            })
          },
          fail(res) { //否则，进入登陆界面
            //console.log(res.data);
            wx.showToast({
              title: '未绑定用户',
            })
          }
        })

    }
})
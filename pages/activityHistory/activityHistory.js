//api√
const app = getApp()

Page({
    data: {
        title: '活动',
        nowList: '0',
        hasUserInfo: false,
        currentTab: 0,
        navScrollLeft: 0,
        qwe: '',
        status: 1,
        imgShow: 0,
        savedTime: '',
        checkIn: '',
        canIUse: wx.canIUse('button.open-type.getUserInfo'),
        //接口数组
      APIs: ['https://qzimp.cn/api/csp-asso/getActStuRelationSignedByStuId',
            'https://qzimp.cn/api/csp-asso/getStartedActAndRelByStuId',
            'https://qzimp.cn/api/csp-asso/getActStuRelationFinishedByStuId'
        ],
        navData: [{
            text: '已报名'
        }, {
            text: '进行中'
        }, {
            text: '参加过'
        }],
        list: [],
        images: [],

    },
    //事件处理函数
    onLoad: function() {
        var that = this
        var i;
        //获取当前时间
        var timestamp = Date.parse(new Date());
        var date = new Date(timestamp);
        that.setData({
                month: (date.getMonth() + 1 < 10 ? +(date.getMonth() + 1) : date.getMonth() + 1),
                date: date.getDate() < 10 ? '0' + date.getDate() : date.getDate(),
                navHeight: app.globalData.statusBarHeight + app.globalData.titleBarHeight
            })
            //获取本地缓存 中的navHeight
        wx.getStorage({
                key: "navHeight",
                success: function(res) {
                    console.log("本地缓存navHeight")
                    console.log(res)

                },
            })
            //获取本地缓存
        wx.getStorage({
                key: "userInfo",
                //获取学生学号
                success: function(res) {
                    console.log("本地缓存")
                    console.log(res)
                    that.setData({
                        stuId: res.data.sn
                    });
                    //根据学生学号，获取已报名活动
                    wx.request({
                        url: that.data.APIs[that.data.currentTab] + '?stuId=' + that.data.stuId,
                        data: {},
                        header: {
                            'content-type': 'application/json'
                        },
                        method: 'GET',
                        dataType: 'json',
                        responseType: 'text',
                        success: function(res) {
                            console.log('~~~~~~~~~~')
                            console.log(res.data)
                            that.setData({
                                list: res.data
                            })

                        }
                    });
                },
            })
            //获取屏幕高度
        wx.getSystemInfo({
            success: function(res) {
                console.log(res)
                that.setData({
                    height: res.screenHeight
                })
            }

        });

    },

    onshow: function() {

    },
    switchNav(event) {
        var that = this;
        var cur = event.currentTarget.dataset.current;

        //每个tab选项宽度占1/5
        // var singleNavWidth = this.data.windowWidth / 3;
        // console.log(singleNavWidth)
        //tab选项居中                            
        // this.setData({
        //     navScrollLeft: (cur - 1) * singleNavWidth
        // })
        if (that.data.currentTab == cur) {
            return false;
        } else {
            that.setData({
                currentTab: cur
            })
        }
        console.log('API:')
        console.log(that.data.currentTab)
        console.log(that.data.APIs[that.data.currentTab] + '?stuId=' + that.data.stuId)
            //切换选择时，重新获取数据
        wx.request({
            url: that.data.APIs[that.data.currentTab] + '?stuId=' + that.data.stuId,
            data: {},
            header: {
                'content-type': 'application/json'
            },
            method: 'GET',
            dataType: 'json',
            responseType: 'text',
            success: function(res) {
                console.log('switchNav~~~~~~~~~~')
                console.log(res)
                that.setData({
                        list: res.data
                    })
                    //格式化时间，留取前十个字符
                if (that.data.currentTab == 1) {
                    for (let index = 0; index < that.data.list.length; index++) {
                        that.data.list[index].activityStartTime = that.data.list[index].activityStartTime.substr(0, 10);
                        console.log(that.data.list[index].activityStartTime)
                        that.data.list[index].activityFinishTime = that.data.list[index].activityFinishTime.substr(0, 10);
                    }
                }
            }
        });

    },
    switchTab(event) {
        console.log(event)
        var cur = event.detail.current;
        var that = this;
        // console.log('WWWW')
        // console.log(cur)
        var singleNavWidth = that.data.windowWidth / 3;
        that.setData({
            currentTab: cur,
            navScrollLeft: (cur - 2) * singleNavWidth
        });

        //切换选择时，重新获取数据
        wx.request({
            url: that.data.APIs[that.data.currentTab] + '?stuId=' + that.data.stuId,
            data: {},
            header: {
                'content-type': 'application/json'
            },
            method: 'GET',
            dataType: 'json',
            responseType: 'text',
            success: function(res) {
                console.log('switchTab~~~~~~~~~~')
                console.log(res)
                that.setData({
                        list: res.data
                    })
                    //格式化时间，留取前十个字符
                if (that.data.currentTab == 1) {
                    for (let index = 0; index < that.data.list.length; index++) {
                        that.data.list[index].activityStartTime = that.data.list[index].activityStartTime.substr(0, 10);
                        console.log(that.data.list[index].activityStartTime)
                        that.data.list[index].activityFinishTime = that.data.list[index].activityFinishTime.substr(0, 10);
                    }
                }
            }
        });
    },
    //点击不同选择时下的列表时，触发的方法
    selectMethod: function(e) {
        var that = this
        if (that.data.currentTab != 1) {
            that.jumpActivity(e)
        } else {
            that.listTap(e)
        }
    },
    //点击最外层列表展开收起
    listTap: function(e) {
        // console.log(this.data.list);
        var that = this
        let Index = e.currentTarget.dataset.index, //获取点击的下标值
            list = that.data.list;
        console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!1112")
        console.log(list);
        console.log(list[Index]);
        console.log(!list[Index].show);
        list[Index].show = !list[Index].show || false; //变换其打开、关闭的状态

        if (list[Index].show) { //如果点击后是展开状态，则让其他已经展开的列表变为收起状态
            console.log(list);
            that.packUp(list, Index);
        }

        this.setData({
            list,
            index: e.currentTarget.dataset.index
        });
        wx.getStorage({
            //获取本地缓存上一次签到时间
            key: list[Index].activityId,
            success: function(res) {
                console.log("本地缓存time")
                console.log(res)
                that.setData({
                    savedTime: res.data
                })
                console.log(that.data.savedTime)
                    //如果上一次签到时间为空，则签到状态为可签
                if (that.data.savedTime == '') {
                    that.data.checkIn = 0
                    console.log("that.data.checkIn_1")
                    console.log(that.data.checkIn)
                    if (that.data.checkIn == 0) {
                        var intermediary = that.data.list[that.data.index]
                        intermediary.buttonStatus = 0
                        that.setData({
                            ['list[' + that.data.index + ']']: intermediary,
                        })
                    }
                } else if (that.data.month > that.data.savedTime.month) {
                    //若月份更新，则签到状态为可签
                    that.data.checkIn = 0
                    console.log("that.data.checkIn_2")
                    console.log(that.data.checkIn)
                    if (that.data.checkIn == 0) {
                        var intermediary = that.data.list[that.data.index]
                        intermediary.buttonStatus = 0
                        that.setData({
                            ['list[' + that.data.index + ']']: intermediary,
                        })
                    }
                } else if (that.data.date > that.data.savedTime.date) {
                    //若日期更新，则签到状态为可签
                    that.data.checkIn = 0
                    console.log("that.data.checkIn_3")
                    console.log(that.data.checkIn)
                    if (that.data.checkIn == 0) {
                        var intermediary = that.data.list[that.data.index]
                        intermediary.buttonStatus = 0
                        that.setData({
                            ['list[' + that.data.index + ']']: intermediary,
                        })
                    }
                } else {
                    //否则，签到状态为已签
                    that.data.checkIn = 1
                    console.log("that.data.checkIn_4")
                    console.log(that.data.checkIn)
                    if (that.data.checkIn == 1) {
                        var intermediary = that.data.list[that.data.index]
                        intermediary.buttonStatus = 1
                        that.setData({
                            ['list[' + that.data.index + ']']: intermediary,

                        })
                    }
                }

            },
        })
    },
    //让所有的展开项，都变为收起
    packUp(data, index) {
        for (let i = 0, len = data.length; i < len; i++) { //其他最外层列表变为关闭状态
            if (index != i) {
                data[i].show = false;
            }
        }
    },
    //查看活动详情
    jumpActivity: function(e) {
        console.log("活动列表链接跳转")
        console.log(this.data.list)
        var x = e.currentTarget.dataset.index
        var end
        if (this.data.currentTab != 2) {

        } else {
            end = 1
        }
        wx.navigateTo({
            url: '../activity/activity?nameData=' + this.data.list[x].actName + '&activityId=' + this.data.list[x].actId + '&end=' + end
        })
    },
    //签到取证
    evidenceAndChange: function(e) {
        var util = require('../../utils/util.js')
        var that = this
        console.log(that.data.index)
        wx.chooseImage({
            count: 1,
            sizeType: ['original', 'compressed'],
            sourceType: ['camera'],
            success: function(res) {
                console.log("list")
                console.log(that.data.list[that.data.index])
                var intermediary = that.data.list[that.data.index]
                intermediary.path = res.tempFiles[0].path
                intermediary.imgShow = 1
                that.setData({
                    ['list[' + that.data.index + ']']: intermediary,
                })

                var actId = that.data.list[that.data.index].activityId
                var stuId = that.data.stuId
                var path = that.data.list[that.data.index].path
                console.log("path")
                console.log(path)
                    //发送学生学号及其图片
                wx.request({
                  url: 'https://qzimp.cn/api/csp-asso/addActRegOne?actId=' + actId + '&stuId=' + stuId + '&regImg=' + path,
                    data: {},
                    header: { 'content-type': 'application/json' },
                    method: 'post',
                    dataType: 'json',
                    responseType: 'text',
                    success: function(res) {
                        console.log(res)
                            //若成功，更改签到状态，并保存时间
                        if (typeof(res.data) == "string") {
                            var intermediary = that.data.list[that.data.index]
                            intermediary.buttonStatus = 1 //更改签到状态
                            that.setData({
                                    ['list[' + that.data.index + ']']: intermediary,
                                })
                                //签到成功，保存当前日期
                            var timestamp = Date.parse(new Date());
                            var date = new Date(timestamp);
                            var time = {
                                month: (date.getMonth() + 1 < 10 ? +(date.getMonth() + 1) : date.getMonth() + 1),
                                date: date.getDate() < 10 ? +date.getDate() : date.getDate()
                            }
                            console.log("-------------------------------------")
                            wx.setStorage({
                                key: actId,
                                data: time
                            })
                            console.log("-------------------------------------")
                        } else {
                            wx.showToast({
                                title: '签到失败!',
                                image: '/images/Tpis.png'
                            })
                        }

                        //签到成功，保存当前日期end
                    },
                    fail: () => {},
                    complete: () => {}
                });
            }

        });
    },
    //查看签到记录
    showNote: function() {
        this.setData({
            showNote: 1
        })
        var that = this
        var actId = that.data.list[that.data.index].activityId
        var stuId = that.data.stuId
        wx.request({
          url: 'https://qzimp.cn/api/csp-asso/getActRegByActIdAndStuId?actId=' + actId + '&stuId=' + stuId,
            data: {},
            header: { 'content-type': 'application/json' },
            method: 'GET',
            dataType: 'json',
            responseType: 'text',
            success: function(res) {
                console.log("签到记录")
                console.log(res)
                var register = res.data
                for (let index = 0; index < register.length; index++) {
                    register[index].registerTime = register[index].registerTime.substr(0, 19).replace('T', ' ');;
                    console.log(register[index].registerTime)
                }
                that.setData({
                    register: register
                })
            },
            fail: () => {},
            complete: () => {}
        });
    },
    //关闭查看签到记录
    noteBg_off: function() {
        this.setData({
            showNote: 0
        })
    }
})
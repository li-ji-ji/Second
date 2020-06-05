//api√
const app = getApp()

Page({
    data: {
        title: '申请书',
        nowList: '0',
        hasUserInfo: false,
      APIs: ['https://qzimp.cn/api/apply/getApplyByStuIdAndCheckStatus?checkStatus=0',
            'https://qzimp.cn/api/apply/getApplyByStuIdAndCheckStatus?checkStatus=1'
        ],
        canIUse: wx.canIUse('button.open-type.getUserInfo'),
        navData: [{
                text: '审核中'
            },
            {
                text: '已完成'
            }
        ],
        list: [{
                listName: '列表1',

                itemName: '子列表1-1',
                content: '1-1中的内容',
                time: '2015-05-06'

            },
            {
                listName: '列表2',

                itemName: '子列表2-3',
                content: '2-3中的内容',
                time: '2015-11-06'

            }, {
                listName: '列表3',

                itemName: '子列表1-3',
                content: '3-3中的内容',
                time: '2015-05-30'

            }
        ],
        currentTab: 0,
        navScrollLeft: 0,
        qwe: ''
    },
    //事件处理函数
    onLoad: function() {
        // console.log(this.data.lists[this.data.currentTab].list)
        // if (app.globalData.userInfo) {
        //     this.setData({
        //         userInfo: app.globalData.userInfo,
        //         hasUserInfo: true
        //     })
        // } else if (this.data.canIUse) {
        //     // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
        //     // 所以此处加入 callback 以防止这种情况
        //     app.userInfoReadyCallback = res => {
        //         this.setData({
        //             userInfo: res.userInfo,
        //             hasUserInfo: true
        //         })
        //     }
        // } else {
        //     // 在没有 open-type=getUserInfo 版本的兼容处理
        //     wx.getUserInfo({
        //         success: res => {
        //             app.globalData.userInfo = res.userInfo
        //             this.setData({
        //                 userInfo: res.userInfo,
        //                 hasUserInfo: true
        //             })
        //         }
        //     })
        // }


        // wx.getSystemInfo({
        //     success: (res) => {
        //         this.setData({
        //             pixelRatio: res.pixelRatio,
        //             windowHeight: res.windowHeight,
        //             windowWidth: res.windowWidth
        //         })
        //     },
        // }),
        var that = this
        var i;
        wx.getStorage({
            //获取本地缓存 

            key: "userInfo",
            success: function(res) {
                console.log("本地缓存")
                console.log(res.data.sn)

                that.setData({
                    stuId: res.data.sn
                });

                wx.request({
                    url: that.data.APIs[that.data.currentTab] + '&stuId=' + that.data.stuId,
                    data: {},
                    header: { 'content-type': 'application/json' },
                    method: 'GET',
                    dataType: 'json',
                    responseType: 'text',
                    success: function(res) {
                        console.log('~~~~~~~~~~')
                        console.log(res)
                        that.setData({
                            list: res.data
                        })
                        for (let index = 0; index < that.data.list.length; index++) {
                            that.data.list[index].applyTime = that.data.list[index].applyTime.substr(0, 10);
                        }

                    }
                });
            },
        })

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
        console.log(that.data.APIs[that.data.currentTab] + '&stuId=' + that.data.stuId)
        wx.request({
            url: that.data.APIs[that.data.currentTab] + '&stuId=' + that.data.stuId,
            data: {},
            header: { 'content-type': 'application/json' },
            method: 'GET',
            dataType: 'json',
            responseType: 'text',
            success: function(res) {
                console.log('~~~~~~~~~~')
                console.log(res)
                that.setData({
                    list: res.data
                })
                for (let index = 0; index < that.data.list.length; index++) {
                    that.data.list[index].applyTime = that.data.list[index].applyTime.substr(0, 10);
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

        // console.log('####3')
        // console.log(this.data.currentTab)
        wx.request({
            url: that.data.APIs[that.data.currentTab] + '&stuId=' + that.data.stuId,
            data: {},
            header: { 'content-type': 'application/json' },
            method: 'GET',
            dataType: 'json',
            responseType: 'text',
            success: function(res) {
                console.log('~~~~~~~~~~')
                console.log(res)
                that.setData({
                    list: res.data
                })
                for (let index = 0; index < that.data.list.length; index++) {
                    that.data.list[index].applyTime = that.data.list[index].applyTime.substr(0, 10);
                }

            }
        });
    },
    //点击最外层列表展开收起
    listTap(e) {
        console.log(this.data.list);
        let Index = e.currentTarget.dataset.index, //获取点击的下标值
            list = this.data.list;
        console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!1112")
        console.log(list);
        console.log(list[Index]);
        console.log(!list[Index].show);
        list[Index].show = !list[Index].show || false; //变换其打开、关闭的状态

        if (list[Index].show) { //如果点击后是展开状态，则让其他已经展开的列表变为收起状态
            console.log(list);
            this.packUp(list, Index);
        }

        this.setData({
            list

        });
    },
    //让所有的展开项，都变为收起
    packUp(data, index) {
        for (let i = 0, len = data.length; i < len; i++) { //其他最外层列表变为关闭状态
            if (index != i) {
                data[i].show = false;
            }
        }
    },
})
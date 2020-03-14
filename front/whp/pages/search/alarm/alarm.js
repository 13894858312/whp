// pages/search/alarm/alarm.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    chemicalId: '',
    chemicalName: '',
    position: {
      longitude: '',
      latitude: ''
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.setData({
      chemicalId: options.chemicalId,
      chemicalName: options.chemicalName,
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  locate: function(){
    var that = this
    wx.chooseLocation({
      success: function (res) {
        that.setData({
          position: {
            longitude: res.longitude,
            latitude: res.latitude
          },
        })
      },
    })
  },

  alarmSubmit: function (e) {
    var alarmData = e.detail.value;
    alarmData.position = alarmData.position.replace(/\s+/g, '')
    if (alarmData.title == "") {
      wx.showToast({
        title: '未填写描述问题',
        icon: 'none'
      })
    }
    else if (alarmData.username == "") {
      wx.showToast({
        title: '未填写名字',
        icon: 'none'
      })
    }
    else if (alarmData.position == "" || alarmData.position == ",") {
      wx.showToast({
        title: '未填写位置信息',
        icon: 'none'
      })
    }
    else {
      alarmData.chemicalId = this.data.chemicalId
      wx.request({
        url: 'https://chem.ufeng.top/whp/alarm/add',
        method: 'post',
        header: {
          // 'content-type': 'application/x-www-form-urlencoded'
          'content-type': 'application/json'
        },
        data: alarmData,
        success: function (res) {
          wx.showToast({
            title: '提交成功',
          })
          console.log(res.data)
        }
      });
    }
  }
})
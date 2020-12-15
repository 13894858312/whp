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
            latitude: res.latitude,
            address : res.address
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
        title: '未填写坐标',
        icon: 'none'
      })
    }
    else if (alarmData.address == "") {
      wx.showToast({
        title: '未填写具体位置',
        icon: 'none'
      })
    }
    else {
      console.log(alarmData)
      alarmData.chemicalId = this.data.chemicalId
      var signature=wx.getStorageSync('signature');
      wx.request({
        url: 'http://121.40.243.225:8091/whp/alarm/add',
        method: 'post',
        header: {
          // 'content-type': 'application/x-www-form-urlencoded'
          'content-type': 'application/json',
          'signature' : signature
        },
        data: alarmData,
        success: function (res) {
          if (res.data.code != 0) {
            wx.showToast({
              title: '提交失败',
              icon: 'none'
            })
          } else {
            wx.showToast({
              title: '提交成功',
              icon: 'none'
            })
          }
          console.log(res.data)
        }
      });
    }
  }
})
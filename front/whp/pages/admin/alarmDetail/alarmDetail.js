// pages/admin/alarmDetail/alarmDetail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    alarmDetail: undefined,
    position: {
      longitude: '',
      latitude: ''
    },
    markers: [{
      iconPath: "/resources/others.png",
      id: 0,
      latitude: 23.099994,
      longitude: 113.324520,
      width: 50,
      height: 50
    }],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    wx.request({
      url: 'https://chem.ufeng.top/whp/alarm/getDetail',
      data: { alarmId: options.alarmId },
      success: function (res) {
        if (res.data.code != 0) {
          wx.showToast({
            title: '获取数据失败',
          })
        }
        else {
          var pos = res.data.data.position.split(",")
          that.setData({
            alarmDetail: res.data.data,
            position: {
              longitude: pos[0],
              latitude: pos[1]
            },
          });
        }
      }
    })
  },

  locate: function () {
    var that = this
    var longitude = parseFloat(that.data.position.longitude)
    var latitude = parseFloat(that.data.position.latitude)
    wx.openLocation({
      latitude: latitude, // 纬度，范围为-90~90，负数表示南纬
      longitude: longitude, // 经度，范围为-180~180，负数表示西经
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

  }
})
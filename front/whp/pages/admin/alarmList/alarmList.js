// pages/admin/alarmList/alarmList.js
Page({

  /**
   * 页面的初始数据
   * time < 60s 1分钟前
   * 60s < time < 3600s time/60 分钟前
   * 3600s <= time < 86400s time/3600 小时前
   * 86400s <= time < 31536000s time/86400 天前
   * 31536000 <= time time/31536000 年前
   */
  data: {
    alarmList: undefined,
    now: undefined
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  },

  alarmDetail: function (e) {
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/admin/alarmDetail/alarmDetail?alarmId=' + id,
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
    var that = this;
    var timestamp = Date.parse(new Date());
    timestamp = timestamp / 1000;
    that.setData({
      now: timestamp
    })
    console.log("当前时间戳为：" + that.data.now);
    wx.request({
      url: 'http://120.55.54.247:8090/alarm/getList',
      method: 'get',
      success: function (res) {
        if (res.data.code != 0) {
          wx.showToast({
            title: '获取数据失败',
          })
        } else {
          that.setData({
            alarmList: res.data.data,
            length: res.data.data.length
          })
        }
        console.log(that.data.alarmList)
      },
      fail: function (err) {
        console.log(err)
      }
    })
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
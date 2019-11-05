// pages/search/circulate/circulate.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    chemicalName: '汞',
    productNumber: '',
    enterpriseName: '',
    status:['状态1', '状态2', '状态3'],
    statusSelected: 0,
    circulatePosition: '',
    circulateRemark: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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

  statusChange: function (e) {
    this.setData({
      statusSelected: e.detail.value
    })
  },

  circulateSubmit: function () {

  }
})
// pages/search/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    typeList:['名称','CAS'],
    picked:0,
    historyList:[
      {
        cas:'12345',
        name: '甲烷'
      },
      {
        cas:'1234',
        name:'乙烷'
      }
    ]
    //todo：限制长度
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

  bindPickerChange: function (e){
    this.setData({
      picked: e.detail.value
    })
  },

  doSearch: function(){
    wx.navigateTo({
      url: '/pages/search/searchList/list',
    })
  },

  bindHistoryItem: function(e){

  },

  bindQRcode: function(){
    wx.scanCode({
      scanType:['qrCode'],
      success(res) {
        console.log(res)
      },
      fail(res){
        console.log(res)
      }
    })
  }
})
Page({

  /**
   * 页面的初始数据
   */
  data: {
    chemicalName: '汞',
    basicInfo: '基本信息',
    physicochemeclaProperty: '理化特性',
    stabilityAndReactivity: '稳定性和反应性',
    danger: '危险性概述',
    GHS: 'GHS危害性分类',
    handleAndStorage: '操作处置与储存',
    touchControl: '接触控制/个体防护',
    firstaidMeasure: '急救措施',
    leakTreatment: '泄露应急处理',
    disposal: '废弃处置',
    basicInfoHidden: true,
    physicochemeclaPropertyHidden: true,
    stabilityAndReactivityHidden: true,
    dangerHidden: true,
    GHSHidden: true,
    handleAndStorageHidden: true,
    touchControlHidden: true,
    firstaidMeasureHidden: true,
    leakTreatmentHidden: true,
    disposalHidden: true,
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

  basicInfoTap: function (e) {
    this.setData({
      basicInfoHidden: !this.data.basicInfoHidden
    })
  },

  physicochemeclaPropertyTap: function (e) {
    this.setData({
      physicochemeclaPropertyHidden: !this.data.physicochemeclaPropertyHidden
    })
  },

  stabilityAndReactivityTap: function (e) {
    this.setData({
      stabilityAndReactivityHidden: !this.data.stabilityAndReactivityHidden
    })
  },

  dangerTap: function (e) {
    this.setData({
      dangerHidden: !this.data.dangerHidden
    })
  },

  GHSTap: function (e) {
    this.setData({
      GHSHidden: !this.data.GHSHidden
    })
  },

  handleAndStorageTap: function (e) {
    this.setData({
      handleAndStorageHidden: !this.data.handleAndStorageHidden
    })
  },

  touchControlTap: function (e) {
    this.setData({
      touchControlHidden: !this.data.touchControlHidden
    })
  },

  firstaidMeasureTap: function (e) {
    this.setData({
      firstaidMeasureHidden: !this.data.firstaidMeasureHidden
    })
  },

  leakTreatmentTap: function (e) {
    this.setData({
      leakTreatmentHidden: !this.data.leakTreatmentHidden
    })
  },

  disposalTap: function (e) {
    this.setData({
      disposalHidden: !this.data.disposalHidden
    })
  },

  toCirculate: function (e){
    wx.navigateTo({
      url: '/pages/search/circulate/circulate',
    })
  },

  toAlarm: function (e) {
    wx.navigateTo({
      url: '/pages/search/alarm/alarm',
    })
  }

})
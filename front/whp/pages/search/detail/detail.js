Page({
  /**
   * 页面的初始数据
   */
  data: {
    detail:undefined,
    basicInfoHidden: true,
    propertyHidden: true,
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
    //by wx 加载detail数据
    var that = this;
    wx.request({
      url: 'http://120.55.54.247:8090/chemical/getDetail',
      data: {chemicalId : options.chemicalId},
      method :'get',
      success: function(res){
        if (res.data.code != 0) {
          wx.showToast({
            title: '获取数据失败',
          })
        }
        else {
          that.setData({
            detail: res.data.data
          });
          //用于存储历史记录
          var now = {
            id: that.data.detail.id,
            cas: that.data.detail.cas,
            name: that.data.detail.cnName
          };
          var history = wx.getStorageSync('history');
          if(history == ''){
            history = [now];
          }
          else{
            history = JSON.parse(history);
            //非常蠢的去重
            var i = 0;
            while(i < history.length){
              if(history[i].id == now.id){
                history.splice(i, 1);
                break;
              }
              i++;
            }
            history.push(now);
            //限制个数、变量在app.js
            if(history.length > getApp().globalData.limitHistory){
              history.splice(0, 1);
            }
          }
          wx.setStorageSync('history', JSON.stringify(history));
        }
      }
    });
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

  propertyTap: function (e) {
    this.setData({
      propertyHidden: !this.data.propertyHidden
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
    var url = '/pages/search/circulate/circulate'
    var param = '?chemicalId=' + this.data.detail.id + '&chemicalName=' + this.data.detail.cnName
    url = url + param
    wx.navigateTo({
      url: url
    })
  },

  toAlarm: function (e) {
    var url = '/pages/search/alarm/alarm'
    var param = '?chemicalId=' + this.data.detail.id + '&chemicalName=' + this.data.detail.cnName
    url = url + param
    wx.navigateTo({
      url: url
    })
  }

})
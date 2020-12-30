Page({
  /**
   * 页面的初始数据
   */
  data: {
    detail:undefined,
    basicInfoHidden: false,
    emergencyHidden: true,
    propertyHidden: true,
    GHSHidden: true,
    dangerHidden: true,
    preventHidden: true,
    responseHidden: true,
    storeHidden: true,
    disposalHidden: true,
    physicalChemicalHidden: true,
    healthHidden: true,
    environmentHidden:true,
    firstaidMeasureHidden: true,
    leakTreatmentHidden: true,
    handleAndStorageHidden: true,
    engControlHidden: true,
    touchControlHidden: true,
    transAttentionHidden: true,
    bookHidden: true,
    codeUrl: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //by wx 加载detail数据
    var that = this;
    wx.request({
      url: 'https://chem.ufeng.top/whp/chemical/getDetail',
      data: {chemicalId : options.chemicalId, cas: options.cas},
      method: 'post',
      header: {
        'content-type': 'application/json'
      },
      success: function(res){
        if (res.data.code != 0) {
          wx.showToast({
            title: '获取数据失败',
            icon:'none'
          })
        }
        else {
          that.setData({
            detail: res.data.data,
            codeUrl: 'https://chem.ufeng.top' + res.data.data.uri
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

  emergencyTap: function (e) {
    this.setData({
      emergencyHidden: !this.data.emergencyHidden
    })
  },

  propertyTap: function (e) {
    this.setData({
      propertyHidden: !this.data.propertyHidden
    })
  },

  GHSTap: function (e) {
    this.setData({
      GHSHidden: !this.data.GHSHidden
    })
  },

  dangerTap: function (e) {
    this.setData({
      dangerHidden: !this.data.dangerHidden
    })
  },

  preventTap: function (e) {
    this.setData({
      preventHidden: !this.data.preventHidden
    })
  },

  responseTap: function (e) {
    this.setData({
      responseHidden: !this.data.responseHidden
    })
  },

  storeTap: function (e) {
    this.setData({
      storeHidden: !this.data.storeHidden
    })
  },

  disposalTap: function (e) {
    this.setData({
      disposalHidden: !this.data.disposalHidden
    })
  },
  
  physicalChemicalTap: function (e) {
    this.setData({
      physicalChemicalHidden: !this.data.physicalChemicalHidden
    })
  },

  healthTap: function (e) {
    this.setData({
      healthHidden: !this.data.healthHidden
    })
  },

  environmentTap: function (e) {
    this.setData({
      environmentHidden: !this.data.environmentHidden
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

  handleAndStorageTap: function (e) {
    this.setData({
      handleAndStorageHidden: !this.data.handleAndStorageHidden
    })
  },

  engControlTap: function (e) {
    this.setData({
      engControlHidden: !this.data.engControlHidden
    })
  },

  touchControlTap: function (e) {
    this.setData({
      touchControlHidden: !this.data.touchControlHidden
    })
  },

  transAttentionTap: function (e) {
    this.setData({
      transAttentionHidden: !this.data.transAttentionHidden
    })
  },

  bookTap: function (e) {
    this.setData({
      bookHidden: !this.data.bookHidden
    })
  },

  toCirculate: function (e){
    if (wx.getStorageSync('signature') == '') {
      wx.showToast({
        title: '只允许企业用户上报流转信息，如需上报请先登录',
        icon: 'none'
      });
      return;
    }
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
  },

  saveQrCode: function(e) {
    var that = this;
    wx.showModal({
      title: '保存二维码？',
      success: function () {
        wx.downloadFile({
          url: that.data.codeUrl,
          success: function (res) {
            var imageFilePath = res.tempFilePath;
            if (imageFilePath != undefined) {
              wx.saveImageToPhotosAlbum({
                filePath: imageFilePath,
                success: function (data) {
                  wx.showToast({
                    title: "保存成功",
                  })
                }, fail: function (res) {
                  wx.showToast({
                    title: "保存失败",
                    icon: 'none'
                  })
                }
              })
            }
          },
        })
      }
    })
  }

})
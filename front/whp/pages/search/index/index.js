// pages/search/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //用于清空表单
    nothing: '',
    typeList:['名称','CAS'],
    picked:0,
    historyList:undefined
  },

  onLoad: function(options){
  },

  onShow: function(){
    var that = this;
    var history = wx.getStorageSync('history');
    if (history != '') {
      that.setData({
        //翻转使时间倒序
        historyList: JSON.parse(history).reverse()
      })
    }
  },

  bindPickerChange: function (e){
    this.setData({
      picked: e.detail.value
    })
  },

  doSearch: function(e){
    var that = this;
    var input = e.detail.value.input;
    if(input == ''){
      wx.showToast({
        title: '请输入搜索内容',
        icon: 'none'
      });
      return;
    }
    var picked = this.data.picked;
    var param = '';
    if(picked == 0){
      param = '?name=' + input;
    }else if(picked == 1){
      param = '?cas=' + input;
    }
    var url = '/pages/search/searchList/list';
    //调试用
    if(input!=''){
      url += param;
    }
    //清空input
    that.setData({
      nothing: ''
    })
    
    wx.navigateTo({
      url: url,
    })
  },

  bindHistoryItem: function (e) {
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/search/detail/detail?chemicalId=' + id,
    })
  },

  bindQRcode: function(){
    wx.scanCode({
      scanType:['qrCode'],
      success(res) {
        if (res.errMsg == 'scanCode:ok') {
          wx.navigateTo({
            url: res.result
          })
        }
      },
      fail(res){
        console.log(res)
      }
    })
  }
})
// pages/search/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    typeList:['名称','CAS'],
    picked:0,
    historyList:undefined
  },

  onLoad: function(options){
    var that = this;
    var history = wx.getStorageSync('history');
    if(history != ''){
      that.setData({
        historyList: JSON.parse(history)
      })
    }
    console.log(that.data.historyList);
  },

  bindPickerChange: function (e){
    this.setData({
      picked: e.detail.value
    })
  },

  doSearch: function(e){
    var input = e.detail.value.input;
    if(input == ''){
      wx.showModal({
        title: '提示',
        content: '请输入搜索内容'
      });
    }else{
      var picked = this.data.picked;
      var param = '';
      if(picked == 0){
        param = '?name=' + input;
      }else if(picked == 1){
        param = '?cas=' + input;
      }

      wx.navigateTo({
        url: '/pages/search/searchList/list' + param,
      })
    }
  },

  bindHistoryItem: function(e){

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
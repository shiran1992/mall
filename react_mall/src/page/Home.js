import React, { Component } from 'react';
import { Card, CardImg } from 'reactstrap';
import { Carousel } from 'antd';
import BaseConfig from "../config/BaseConfig";
import API from "../utils/API";

class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      recoms: [],
      hots: []
    }
  }

  componentDidMount() {
    this.getRecomList();
    this.getHotList();
  }

  //获取推荐数据
  async getRecomList() {
    let recoms = await API("GetRecomServlet", {}, { method: "get" });
    if (recoms) {
      this.setState({
        recoms: recoms
      });
    }
  }

  //获取热门商品
  async getHotList() {
    let hots = await API("GetHotServlet", {}, { method: "get" });
    if (hots) {
      let shops = [];
      for (let i = 0; i < hots.length; i++) {
        shops.push(hots[i].shop);
      }
      this.setState({
        hots: shops
      });
    }
  }

  //推荐图片轮播
  renderSlider() {
    let slider = [];
    for (let i = 0; i < this.state.recoms.length; i++) {
      slider.push(
        <CardImg key={i} src={BaseConfig.baseUrl + this.state.recoms[i].img} onClick={() => { this.routerTo(this.state.recoms[i].shop.sid) }} />
      )
    }
    return slider;
  }

  //商品列表
  renderShopList() {
    if (this.state.hots.length > 0) {
      var lst = this.state.hots;
      var lstlen = lst.length;
      var jsx = [];
      for (let i = 0; i < lstlen; i++) {
        jsx.push(
          <Card style={{ width: "23%", height: "400px", margin: "12px", border: "1px solid #ccc", float: 'left', fontFamily: 'Microsoft YaHei', cursor: 'pointer' }}
            key={i} onClick={() => {
              this.routerTo(lst[i].sid);
            }}>
            <CardImg top style={{ width: '100%' }} src={BaseConfig.baseUrl + lst[i].head} />
            <div style={{ display: 'flex', alignItems: 'center', marginTop: 20, padding: '0 10px' }}>
              <span style={{ color: '#F40', fontWeight: 700, fontFamily: 'arial' }}>单价：{lst[i].price}元</span>
              <span style={{ backgroundColor: '#F40', color: 'white', fontSize: 12, marginLeft: 10, padding: '0 5px' }}>包邮</span>
              <div style={{ flex: 1 }} />
              <span style={{ fontSize: 12 }}>{lst[i].num}人已付款</span>
            </div>
            <span style={{ color: '#3d3d3d', width: '100%', padding: 10 }}>{lst[i].title}</span>
          </Card>
        );
      }
      return jsx;
    } else {
      return null;
    }
  }

  render() {
    return (
      <div>
        <Carousel autoplay>
          {this.renderSlider()}
        </Carousel>
        <div style={{ width: "1200px", margin: "30px auto", overflow: "hidden" }}>
          <div>
            <h3>热门商品</h3>
            <div style={{ width: "1200px", margin: "0 auto", overflow: "hidden" }}>
              {this.renderShopList()}
            </div>
          </div>
        </div>
      </div>
    )
  }

  //点击商品
  routerTo(id) {
    this.props.history.push({ pathname: '/product/' + id, state: {} });
  }
}

export default Home;

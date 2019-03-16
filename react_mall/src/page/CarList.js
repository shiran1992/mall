import React, { Component } from 'react';
import { Card } from 'reactstrap';
import { Button } from 'antd';
import BaseConfig from "../config/BaseConfig";
import API from "../utils/API";
const Util = require("../Utils/util");

class CarList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      cars: []
    };
  }

  componentDidMount() {
    this.getCarList();
  }

  //获取购物车列表
  getCarList() {
    Util.isLogined((user) => {
      if (user.uid) {
        API("GetCarServlet", { uid: user.uid }, { method: "get" }).then((data) => {
          if (data) {
            this.setState({
              cars: data
            })
          }
        });
      }
    }, this);
  }

  //商品列表
  renderShopList() {
    var lst = this.state.cars;
    var jsx = [];
    for (let i = 0; i < lst.length; i++) {
      let shop = lst[i].shop;
      jsx.push(
        <Card style={{ width: "80%", height: 150, margin: 12, border: "1px solid #ccc", float: 'left', fontFamily: 'Microsoft YaHei' }}
          key={i}>
          <div style={{ display: 'flex', alignItems: 'center', padding: 10 }}>
            <div>
              <span style={{ color: '#3d3d3d', width: '100%' }}>{shop.title}</span>
              <div style={{ marginTop: 10 }}>
                <img style={{ height: 50, width: 50, marginLeft: 10 }} src={BaseConfig.baseUrl + shop.head} />
                <div style={{ display: 'flex', alignItems: 'center', marginTop: 20, padding: '0 10px' }}>
                  <span style={{ color: '#F40', fontWeight: 700, fontFamily: 'arial' }}>单价：{shop.price}元</span>
                  <span style={{ backgroundColor: '#F40', color: 'white', fontSize: 12, marginLeft: 10, padding: '0 5px' }}>包邮</span>
                  <span style={{ fontSize: 12, marginLeft: 30 }}>{shop.num}人已付款</span>
                </div>
              </div>
            </div>
            <div style={{ flex: 1 }} />
            <Button type="danger" block onClick={() => this.routerTo(shop.sid)} style={{ width: 100, marginLeft: 50 }}>去付款</Button>
          </div>
        </Card>
      );
    }
    return jsx;
  }

  render() {
    return (
      <div style={{ display: 'flex', width: 1200, flexDirection: 'column', margin: '0 auto', minHeight: '100vh', alignItems: 'center' }}>
        {this.renderShopList()}
      </div>
    )
  }

  //点击付款
  routerTo(id) {
    this.props.history.push({ pathname: '/pay/' + id, state: {} });
  }
}

export default CarList;
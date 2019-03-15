import React, { Component } from 'react';
import { Card, CardImg, CardText, CardBody, CardTitle, CardSubtitle } from 'reactstrap';
import { message, Button } from 'antd';
import BaseConfig from "../config/BaseConfig";
import API from "../utils/API";
const Util = require("../Utils/util");

class ProductDetail extends Component {
  constructor(props) {
    super(props);
    this.state = {
      shop: {}
    }
  }

  componentDidMount() {
    let sid = this.props.match.params.id;
    this.getShopInfo(sid)
  }

  //获取商品详情
  async getShopInfo(sid) {
    let shop = await API("GetShopBySidServlet", { sid: sid }, { method: "get" });
    if (shop) {
      this.setState({
        shop: shop
      });
    }
  }

  //渲染基础信息
  renderInfo() {
    var data = this.state.shop;
    return (
      <Card style={{ width: "60%", margin: "0 auto", border: "1px solid #eee", fontFamily: 'Microsoft YaHei', overflow: "hidden", position: "relative", padding: "20px" }}>
        <CardImg top style={{ width: '45%', float: "left" }} src={BaseConfig.baseUrl + data.head} />
        <CardBody style={{ width: '52%', position: "absolute", right: "0", top: "0" }}>
          <CardTitle style={{ fontSize: 20, marginTop: 10, fontWeight: 700 }}>{data.title}</CardTitle>
          <div className="price-bg">
            <div className="price-head">
              <span style={{ color: 'white', fontSize: 12 }}>活动中,尽快购买哦~</span>
            </div>
            <div style={{ flex: 1, padding: 20, display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
              <h4 style={{ color: "red" }}>单价：{data.price}元</h4>
              <span style={{ fontSize: 12 }}>{data.num}人已付款</span>
            </div>
          </div>
          <CardText style={{ fontSize: '14px', color: '#666', lineHeight: '28px' }}>{data.intro}</CardText>
          <CardSubtitle style={{ lineHeight: '22px', color: "#888", margin: '-6px 0 18px 0' }}>上架时间：{Util.formatTime(data.time)}</CardSubtitle>
          <div style={{ display: 'flex' }}>
            <Button type="primary" block onClick={() => this.addToCarts(data)} style={{ width: 100 }}>加入购物车</Button>
            <Button type="danger" block onClick={() => this.addToCarts(data)} style={{ width: 100, marginLeft: 50 }}>去付款</Button>
          </div>
        </CardBody>
      </Card>
    );
  }

  //渲染详情图片
  renderDetailImgs() {
    let imgUrls = [
      "/src/img/detail_004.jpg",
      "/src/img/detail_005.jpg",
      "/src/img/detail_006.jpg",
      "/src/img/detail_007.jpg",
      "/src/img/detail_008.jpg",
    ];
    let imgs = imgUrls.map((e, i) => {
      return (
        <img key={i} src={e} />
      );
    })
    return imgs;
  }

  render() {
    return (
      <div style={{ margin: "40px 0" }}>
        {this.renderInfo()}
        <div style={{ backgroundColor: 'red', width: "50%", margin: "40px auto", display: 'flex', flexDirection: 'column' }}>
          <img src="/src/img/detail_head.jpg" />
          <img src="/src/img/detail_001.jpg" />
          {this.renderDetailImgs()}
          <img src="/src/img/detail_003.jpg" />
        </div>
      </div>
    )
  }

  //加入购物车
  addToCarts(shop) {
    Util.isLogined((user) => {
      if (user.uid && shop.sid) {
        API("AddToCarServlet", { sid: shop.sid, uid: user.uid }, { method: "get" }).then((data) => {
          if (data) {
            message.success("加入成功！");
          }
        });

      }
    }, this);
  }
}

export default ProductDetail;

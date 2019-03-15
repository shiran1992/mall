import React, { Component } from 'react';
import { connect } from 'react-redux';
import { productDetails, addToCart } from '../actions';
import { NavLink } from 'react-router-dom';
import { Card, CardImg, CardText, CardBody, CardTitle, CardSubtitle } from 'reactstrap';
import { message, Button, Timeline } from 'antd';

class OrderDetail extends Component {
  constructor(props) {
    super(props);
    this.state = {
      
    };
  }

  componentDidMount() {
    var productId = this.props.match.params.id;
    
  }

  //渲染基础信息
  renderInfo() {
    var data = this.props.rows;
    data = {
      img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
      title: "飞利浦macbookpro转接口苹果电脑转换器typec拓展坞",
      price: 800.00,
      time: '2019-01-01',
      content: "众所周知一款车的外观对于一款，消费者所想要的是一款内外兼修的汽车",
    };
    return (
      <Card style={{ width: "80%", margin: "0 auto", border: "1px solid #ccc", fontFamily: 'Microsoft YaHei', overflow: "hidden", position: "relative", padding: "20px" }}>
        <Timeline>
          <Timeline.Item color="green">Create a services site 2015-09-01</Timeline.Item>
          <Timeline.Item color="green">Create a services site 2015-09-01</Timeline.Item>
          <Timeline.Item color="red">
            <p>Solve initial network problems 1</p>
            <p>Solve initial network problems 2</p>
            <p>Solve initial network problems 3 2015-09-01</p>
          </Timeline.Item>
          <Timeline.Item>
            <p>Technical testing 1</p>
            <p>Technical testing 2</p>
            <p>Technical testing 3 2015-09-01</p>
          </Timeline.Item>
        </Timeline>
        <CardBody style={{ position: "absolute", right: "0", top: "0" }}>
          <CardTitle style={{ fontSize: 20, marginTop: 10, fontWeight: 700 }}>{data.title}</CardTitle>
          <div className="price-bg">
            <div className="price-head">
              <span style={{ color: 'white', fontSize: 12 }}>活动中,尽快购买哦~</span>
            </div>
            <div style={{ flex: 1, padding: 20, display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
              <h4 style={{ color: "red" }}>单价：{data.price}元</h4>
              <span style={{ fontSize: 12 }}>121人已付款</span>
            </div>
          </div>
          <CardText style={{ fontSize: '14px', color: '#666', lineHeight: '28px' }}>收货地址：</CardText>
          <CardText style={{ fontSize: '14px', color: '#666', lineHeight: '28px' }}>联系电话：</CardText>
        </CardBody>
      </Card >
    );
  }

  render() {
    let data = {
      img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
      title: "飞利浦macbookpro转接口苹果电脑转换器typec拓展坞",
      price: 800.00,
      time: '2019-01-01',
      content: "众所周知一款车的外观对于一款，消费者所想要的是一款内外兼修的汽车",
    };
    return (
      <div style={{ margin: "40px 0", minHeight: '80vh' }}>
        {this.renderInfo()}
        <div style={{ display: 'flex', width: '100%', justifyContent: 'center', marginTop: 10 }}>
          <Card style={{ width: "80%", margin: "0 auto", border: "1px solid #ccc", float: 'left', fontFamily: 'Microsoft YaHei' }}
            onClick={() => {
              this.routerTo();
            }}>
            <div style={{ display: 'flex', alignItems: 'center', padding: 10 }}>
              <div>
                <div style={{ marginTop: 10 }}>
                  <img style={{ height: 50, width: 50, marginLeft: 10 }} src={data.img} />
                  <span style={{ marginTop: 10, fontSize: 12, marginLeft: 10 }}>2019-03-09 12:28:36</span>
                </div>
              </div>
              <div style={{ flex: 1 }} />
              <div style={{ display: 'flex', flexDirection: 'column' }}>
                <span style={{ fontSize: 18, fontWeight: 700, marginBottom: 20 }}>交易成功</span>
                <span>实付款：<span style={{ fontSize: 18, fontWeight: 500 }}>89.00</span></span>
              </div>
            </div>
          </Card>
        </div>
      </div>
    )
  }
}

export default OrderDetail;

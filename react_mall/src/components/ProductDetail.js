import React, { Component } from 'react';
import { connect } from 'react-redux';
import { productDetails, addToCart } from '../actions';
import { NavLink } from 'react-router-dom';
import { Card, CardImg, CardText, CardBody, CardTitle, CardSubtitle } from 'reactstrap';
import { message, Button } from 'antd';

const mapStateToProps = (state) => {
  return {
    rows: state.counter.lists.rows,
    total: state.counter.lists.total
  }
}
class ProductDetail extends Component {
  componentDidMount() {
    var productId = this.props.match.params.id;
    this.props.productDetails({ productId });
  }

  addToCarts = (product) => {
    this.props.addToCart(product)
  }

  show() {
    var data = this.props.rows;
    data = {
      img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
      title: "飞利浦macbookpro转接口苹果电脑转换器typec拓展坞",
      price: 800.00,
      time: '2019-01-01',
      content: "众所周知一款车的外观对于一款，消费者所想要的是一款内外兼修的汽车",
    };
    return (
      <Card style={{ width: "90%", margin: "0 auto", border: "1px solid #eee", fontFamily: 'Microsoft YaHei', overflow: "hidden", position: "relative", padding: "20px" }}>
        <CardImg top style={{ width: '45%', float: "left" }} src={data.img} />
        <CardBody style={{ width: '52%', position: "absolute", right: "0", top: "0" }}>
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
          <CardText style={{ fontSize: '14px', color: '#666', lineHeight: '28px' }}>{data.content}</CardText>
          <CardSubtitle style={{ lineHeight: '22px', color: "#888", margin: '-6px 0 18px 0' }}>上架时间：{data.time}</CardSubtitle>
          <div style={{ display: 'flex' }}>
            <Button type="primary" block onClick={() => this.addToCarts(data)} size="sm" style={{ width: 100 }}>加入购物车</Button>
            <Button type="danger" block onClick={() => this.addToCarts(data)} size="sm" style={{ width: 100, marginLeft: 50 }}>去付款</Button>
          </div>
        </CardBody>
      </Card >
    );
  }

  render() {
    // const {lists} = this.props;
    const { rows, total } = this.props;
    return (
      <div style={{ margin: "40px 0" }}>
        {this.show()}
        <div style={{backgroundColor: 'red', width: "90%", margin: "40px auto"}}>
          111111
        </div>
      </div>
    )
  }
}

export default connect(mapStateToProps, { productDetails, addToCart })(ProductDetail);

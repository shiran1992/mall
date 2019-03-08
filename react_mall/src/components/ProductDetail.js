import React, { Component } from 'react';
import axios from 'axios';
import { connect } from 'react-redux';
import { productDetails, addToCart } from '../actions';
import { NavLink } from 'react-router-dom';
import {
  Card, CardImg, CardText, CardBody,
  CardTitle, CardSubtitle, Button
} from 'reactstrap';

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
      content: "众所周知一款车的外观对于一款车的销量的影响是何其的重要。但是，在今天竞争如此激烈的汽车市场上仅仅只是有出色的外观是不够的，消费者所想要的是一款内外兼修的汽车",
    };
    var carUrl = '/carts';
    var homeUrl = '/';
    return (
      <Card style={{ width: "1000px", margin: "0 auto", border: "2px solid #ccc", fontFamily: 'Microsoft YaHei', overflow: "hidden", position: "relative", padding: "20px" }}>
        <CardImg top style={{ width: '45%', float: "left" }} src={data.img} />
        <CardBody style={{ width: '52%', position: "absolute", right: "0", top: "0" }}>
          <CardTitle style={{ height: "90px", overflow: 'hidden', lineHeight: "35px", margin: '10px 0 0 0' }}>{data.title}</CardTitle>
          <CardSubtitle style={{ color: "red", lineHeight: '18px', margin: '-6px 0 18px 0' }}>单价：${data.price}</CardSubtitle>
          <CardText style={{ fontSize: '14px', color: '#666', lineHeight: '28px' }}>{data.content}</CardText>
          <CardSubtitle style={{ lineHeight: '22px', color: "#888", margin: '-6px 0 18px 0' }}>上架时间：{data.time}</CardSubtitle>
          <NavLink to={homeUrl}>回到首页</NavLink>
          <Button onClick={() => this.addToCarts(data)} size="sm" style={{ margin: "0 10px" }}>加入购物车</Button>
          <NavLink to={carUrl}>去付款</NavLink>
        </CardBody>
      </Card>)
  }


  render() {
    // const {lists} = this.props;
    const { rows, total } = this.props;
    return (
      <div style={{ margin: "40px 0" }}>
        {this.show()}
      </div>
    )
  }
}

export default connect(mapStateToProps, { productDetails, addToCart })(ProductDetail);

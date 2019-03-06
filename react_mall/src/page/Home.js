import React, { Component } from 'react';
import { connect } from 'react-redux';
import { NavLink } from 'react-router-dom';
import { addToCart } from '../actions';
import {
  Card, CardImg, CardText, CardBody,
  CardTitle, CardSubtitle, Button, UncontrolledCarousel, Media
} from 'reactstrap';
import BaseConfig from "../config/BaseConfig";
import axios from 'axios';
import API from "../utils/API";

const mapStateToProps = (state) => {
  return {
    rows: state.counter.lists.rows,
    total: state.counter.lists.total
  }
}

const items = [
  {
    src: 'https://i1.mifile.cn/a4/xmad_15471129430061_HgNMC.jpg',
    altText: 'Slide 2',
    caption: 'Slide 2',
    header: 'Slide 2 Header'
  },
  {
    src: 'https://i1.mifile.cn/a4/xmad_15476374946177_ZTGJq.jpg',
    altText: 'Slide 2',
    caption: 'Slide 2',
    header: 'Slide 2 Header'
  },
  {
    src: 'https://i1.mifile.cn/a4/xmad_15476455699512_MQwfF.jpg',
    altText: 'Slide 3',
    caption: 'Slide 3',
    header: 'Slide 3 Header'
  }
];

const items1 = [{
  src: 'https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg',
  altText: 'Slide 2',
  caption: 'Slide 2',
  header: 'Slide 2 Header'
},
{
  src: 'https://m.360buyimg.com/babel/jfs/t1/23074/29/5780/94208/5c412dd0Efc9730d3/e4cca6056745bd50.jpg',
  altText: 'Slide 2',
  caption: 'Slide 2',
  header: 'Slide 2 Header'
},
{
  src: 'https://img1.360buyimg.com/pop/jfs/t1/14819/40/5437/95413/5c3efdcdE402b396e/3e112f85e702b176.jpg',
  altText: 'Slide 3',
  caption: 'Slide 3',
  header: 'Slide 3 Header'
}];



class Home extends Component {

  addToCarts = (product) => {
    this.props.addToCart(product)
  }

  constructor(props) {
    super(props);
    this.state = {
      list: []
    }
  }

  componentDidMount() {
    this.getData();
  }
 
  async getData() {
    let data = await API(BaseConfig.baseUrl + "GetExpendsServlet?uid=7", { uid: 7 }, { method: "get" });
    if (data) {
      this.setState({
        list: [1,2,3,4,5,6,7,8,9,10]
      })
    }
  }

  newlist() {
    if (this.state.list.length > 0) {
      var lst = this.state.list;
      var lstlen = lst.length;
      var jsx = [];
      for (let i = 0; i < lstlen - 1; i++) {
        var newUrl = '/new/' + lst[i].id;
        jsx.push(
          <NavLink to={newUrl} key={i} style={{ color: "#333" }}>
            <Media style={{ width: "100%" }}>
              <Media heading style={{
                fontSize: "16px", width: "100%", overflow: "hidden", whiteSpace: "nowrap",
                textOverflow: "ellipsis"
              }}>
                {lst[i].id + 1}: {lst[i].title}
              </Media>
            </Media>
          </NavLink>
        )
      }
      return jsx;
    } else {
      return null;
    }
  }

  showlist() {
    if (this.state.list.length > 0) {
      var lst = this.state.list;
      var lstlen = lst.length;
      var jsx = [];
      var carUrl = '/carts';
      for (let i = 0; i < lstlen; i++) {
        var detaiUrl = '/product/' + lst[i].id;
        jsx.push(
          <Card style={{ width: "23%", height: "400px", margin: "12px", border: "2px solid #ccc", float: 'left', fontFamily: 'Microsoft YaHei' }} key={i}>
            <CardImg top style={{ width: '100%' }} src={lst[i].img} />
            <CardBody>
              <CardTitle style={{ width: '100%', height: "48px", overflow: 'hidden', margin: '-6px 0 6px 0' }}>{lst[i].title}</CardTitle>
              <CardSubtitle style={{ width: '100%', color: "red", lineHeight: '18px', margin: '-6px 0 6px 0' }}>单价：${lst[i].price}</CardSubtitle>
              <CardText style={{ width: '100%', height: "36px", overflow: 'hidden', fontSize: '14px', color: '#666', lineHeight: '18px' }}>{lst[i].content}</CardText>
              <NavLink to={detaiUrl}>产品详情</NavLink>
              <Button onClick={() => this.addToCarts(lst[i])} size="sm" style={{ margin: "0 10px" }}>加入购物车</Button>
              <NavLink to={carUrl}>去付款</NavLink>
            </CardBody>
          </Card>
        )
      }
      return jsx;
    } else {
      return null;
    }
  }
  render() {
    return (
      <div>
        <UncontrolledCarousel items={items} />
        <div style={{ width: "1200px", margin: "0 auto", overflow: "hidden" }}>
          <div>
            <Button onClick={()=>{this.push('./login')}}>dghduh</Button>
            <h3>最新商品</h3>
            {this.showlist()}
          </div>
        </div>
      </div>
    )
  }
}

export default connect(mapStateToProps, { addToCart })(Home);

import React, { Component } from 'react';
import { connect } from 'react-redux';
import { NavLink } from 'react-router-dom';
import { addToCart } from '../actions';
import { Card, CardImg, CardText, CardBody, CardTitle, CardSubtitle, UncontrolledCarousel } from 'reactstrap';
import { message, Icon, Button } from 'antd';
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
    let data = await API("GetExpendsServlet", { uid: 7 }, { method: "get" });
    if (data) {
      this.setState({
        list: [
          {
            img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
            title: "飞利浦macbookpro转接口苹果电脑转换器typec拓展坞",
            price: 800.00,
            content: "众所周知一款车的外观对于一款车的销量的影响是何其的重要。但是，在今天竞争如此激烈的汽车市场上仅仅只是有出色的外观是不够的，消费者所想要的是一款内外兼修的汽车",
          },
          {
            img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
            title: "飞利浦macbookpro转接口苹果电脑转换器typec ",
            price: 800.00,
            content: "众所周知一款车的外观对于一款车的销量的影响是何其的重要。但是，在今天竞争如此激烈的汽车市场上仅仅只是有出色的外观是不够的，消费者所想要的是一款内外兼修的汽车",
          },
          {
            img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
            title: "飞利浦macbookpro ",
            price: 800.00,
            content: "众所周知一款车的外观对于一款车的销量的影响是何其的重要。但是，在今天竞争如此激烈的汽车市场上仅仅只是有出色的外观是不够的，消费者所想要的是一款内外兼修的汽车",
          }
        ]
      })
    }
  }

  //商品列表
  renderShopList() {
    if (this.state.list.length > 0) {
      var lst = this.state.list;
      var lstlen = lst.length;
      var jsx = [];
      var carUrl = '/carts';
      for (let i = 0; i < lstlen; i++) {
        jsx.push(
          <div className="shop-card"
            key={i} onClick={() => { this.routerTo(lst[i].id); }}>
            <CardImg top style={{ width: '100%' }} src={lst[i].img} />
            <CardBody>
              <div style={{display: 'flex', alignItems: 'center'}}>
                <span style={{ color: '#F40', fontWeight: 700, fontFamily: 'arial' }}>单价：{lst[i].price}元</span>
                <span style={{backgroundColor: '#F40', color: 'white', fontSize: 12, marginLeft: 10, padding: '0 5px'}}>包邮</span>
                <div style={{flex: 1}}/>
                <span style={{fontSize: 12}}>121人已付款</span>
              </div>
              <span style={{ color: '#3d3d3d', width: '100%', marginTop: 20 }}>{lst[i].title}</span>
            </CardBody>
          </div>
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
        <UncontrolledCarousel items={items} />
        <div style={{ width: "1200px", margin: "0 auto", overflow: "hidden" }}>
          <div style={{ marginTop: 30 }}>
            <h3>最新商品</h3>
            {this.renderShopList()}
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

export default connect(mapStateToProps, { addToCart })(Home);

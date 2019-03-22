import React, { Component } from 'react';

import { NavLink as NLink } from 'react-router-dom';
import { Collapse, Navbar, NavbarToggler, Nav, NavItem } from 'reactstrap';
import { Menu, Dropdown, Icon } from 'antd';

export default class Navigator extends Component {

  constructor(props) {
    super(props);
    this.state = {
      isOpen: false
    };
    this.toggle = this.toggle.bind(this);
    this.userInfo = "";
    let userInfo = localStorage.getItem('userinfo');
    if (userInfo) {
      this.userInfo = JSON.parse(userInfo);
    }
  }

  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }

  render() {
    let style = { fontSize: "14px", lineHight: "24px", margin: '0 10px' };
    const menu = (
      <Menu>
        <Menu.Item>
          <a target="_blank" rel="noopener noreferrer" href="#/login" onClick={()=>{this.onClickBack();}}>退出登录</a>
        </Menu.Item>
      </Menu>
    );
    let view = this.userInfo ?
      <Dropdown overlay={menu}>
        <a className="ant-dropdown-link" href="#">
          {this.userInfo.name} <Icon type="down" />
        </a>
      </Dropdown> :
      <NavItem style={style}>
        <NLink to="/login">登录</NLink>
      </NavItem>;
    return (
      <div>
        <Navbar color="light" expand="md">
          <NavbarToggler onClick={this.toggle} />
          <Collapse isOpen={this.state.isOpen} navbar>
            <Nav className="ml-auto" navbar>
              <NavItem style={style}>
                <NLink to="/" exact>首页</NLink>
              </NavItem>
              <NavItem style={style}>
                <NLink to="/products">产品中心</NLink>
              </NavItem>
              <NavItem style={style}>
                <NLink to="/carts">购物车</NLink>
              </NavItem>
              <NavItem style={style}>
                <NLink to="/about">关于我们</NLink>
              </NavItem>
              {view}
            </Nav>
          </Collapse>
        </Navbar>
      </div>
    );
  }

  onClickBack() {
    localStorage.setItem("userinfo", "");
  }
}
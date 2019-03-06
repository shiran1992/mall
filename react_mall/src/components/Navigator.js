import React, { Component } from 'react';

import { NavLink as NLink } from 'react-router-dom';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem
} from 'reactstrap';

export default class Navigator extends Component {

  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      isOpen: false
    };
  }

  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }

  render() {
    let style = { fontSize: "14px", lineHight: "24px", margin: '0 10px' };
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
                <NLink to="/product">产品中心</NLink>
              </NavItem>
              <NavItem style={style}>
                <NLink to="/about">关于我们</NLink>
              </NavItem>
              <NavItem style={style}>
                <NLink to="/carts">购物车</NLink>
              </NavItem>
              <NavItem style={style}>
                <NLink to="/login">登录</NLink>
              </NavItem>
            </Nav>
          </Collapse>
        </Navbar>
      </div>
    );
  }
}
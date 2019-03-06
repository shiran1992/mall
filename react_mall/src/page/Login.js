import React, { Component } from 'react';
import { Row, Col, Menu, Icon, Button, Input } from 'antd';
import { Slider } from 'antd';


class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: '',
            pwd: ''
        };
    }

    emitEmpty() {
        this.userNameInput.focus();
        this.setState({ userName: '' });
    }

    onChangeUserName(e) {
        this.setState({ userName: e.target.value });
    }

    render() {
        const { userName } = this.state;
        const suffix = userName ? <Icon type="close-circle" onClick={this.emitEmpty} /> : null;
        return (
            <div style={{ margin: "0 auto", overflow: "hidden" }}>
                <div id="header">
                    <div className="logo">
                        <h1>1111</h1>
                    </div>
                </div>
                <div id="content">
                    <div className="login-newbg"></div>
                    <div className="content-layout">
                        <div className="login-box-warp">
                            <div className="login-title">登录</div>
                            <div style={{ display: 'flex', alignItems: 'center', marginTop: 40, width: 250, height: 50, }}>
                                <Input
                                    placeholder="手机号"
                                    prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />}
                                    suffix={suffix}
                                    value={userName}
                                    onChange={this.onChangeUserName}
                                    ref={node => this.userNameInput = node}
                                />
                            </div>
                            <div style={{ display: 'flex', alignItems: 'center', marginTop: 20, width: 250, height: 50, }}>
                                <Input.Password placeholder="密码" />
                            </div>
                            <div style={{ marginTop: 40 }}>
                                <Button type="primary" block>登录</Button>
                            </div>
                            <span className="small-text" style={{ float: "right", marginTop: 10, }} onClick={() => { this.routerTo(); }}>
                                注册
                            </span>
                        </div>

                    </div>
                </div>

                <div id="footer">
                    <div className="footer-bd">
                        <p style={{ textAlign: "center" }}>
                            <span>网络文化经营许可证：浙网文[2016]0132-032号</span>
                            <b>|</b>
                            <span>增值电信业务经营许可证：浙B2-20080224-1</span>
                            <b>|</b>
                            <span>信息网络传播视听节目许可证：1109364号</span>
                        </p>
                    </div>
                </div>
            </div>
        )
    }

    //点击注册
    routerTo(v) {
        this.props.history.push({ pathname: `/register`, state: { data: v } })
    }
}

export default Login;
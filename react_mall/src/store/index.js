import { createStore,applyMiddleware } from 'redux'
import reducers from '../reducers'

import thunk from 'redux-thunk'
import logger from 'redux-logger'

const store = createStore(reducers,applyMiddleware(thunk,logger));  // 创建一个仓库
export default store;
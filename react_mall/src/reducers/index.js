import {combineReducers} from 'redux';

import counter from './counter';
import carts from './carts';

export default combineReducers({
    counter,
    carts
})
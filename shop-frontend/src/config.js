

const API_BASE_URL = 'http://localhost:8080/api';

//const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

export const LOGIN_URL = `${API_BASE_URL}/auth/login`;
export const REGISTER_URL = `${API_BASE_URL}/auth/register`;
export const PRODUCTS_URL = `${API_BASE_URL}/products`;

export const INVALID_LOGIN_ERROR_MESSAGE = 'Enter valid login id or password. Please try again.';
export const USER_ALREADY_EXIST = "USername already exists. Please try another name";
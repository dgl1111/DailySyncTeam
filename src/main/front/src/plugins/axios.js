import axios from 'axios'

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080/api',
  timeout: 5000,
  headers: {
    'Content-Type': 'application/json',
  },
})
// 요청 인터셉터
axiosInstance.interceptors.request.use(
  (config) => {
    console.log('requestInfo : ', {
      requestURL: `${config.baseURL}/${config.url}`,
      requestMethod: config.method,
    })
    return config
  },
  (error) => {
    console.error('Request Error:', error)
    return Promise.reject(error)
  },
)
// 응답 인터셉터
axiosInstance.interceptors.response.use(
  (response) => {
    // 응답 데이터를 가공하거나 처리
    // console.log("Response:", response);
    if (response.data.status === 'success') {
      return {
        status: true,
        data: response.data.data,
      }
    } else if (response.data.status === 'fail' || response.data.status === 'error') {
      console.log(response.data.message)
      return {
        status: false,
        message: response.data.message,
      }
    } else {
      return response.data
    }
  },
  (error) => {
    // 응답 에러 처리
    console.error('Response Error:', error.response.data)
    return {
      status: false,
      message: error.response.data.message,
    }
  },
)
export default axiosInstance
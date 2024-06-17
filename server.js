const express = require('express');
const path = require('path');
const compression = require('compression');
const cors = require('cors');
const app = express();
const PORT = 5000;

// Gzip 압축을 사용하도록 설정
app.use(compression());

// CORS 허용
app.use(cors({
  origin: '*',
  methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'],
  allowedHeaders: ['Content-Type', 'Authorization']
}));

// Unity WebGL 빌드 파일 제공
app.use(express.static(path.join(__dirname, 'assets'), {
  setHeaders: (res, path) => {
    if (path.endsWith('.gz')) {
      res.set('Content-Encoding', 'gzip');
    }
  }
}));

app.get('*', (req, res) => {
  res.sendFile(path.join(__dirname, 'assets', 'index.html'));
});

app.listen(PORT, '0.0.0.0', () => {
  console.log(`Server is running on http://0.0.0.0:${PORT}`);
});

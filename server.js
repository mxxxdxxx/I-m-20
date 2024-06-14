const express = require('express');
const path = require('path');
const compression = require('compression');
const app = express();
const PORT = 5000;

// Gzip 압축을 사용하도록 설정
app.use(compression());

// Unity WebGL 빌드 파일 제공
app.use(express.static(path.join(__dirname, 'assets'), {
  setHeaders: (res, path) => {
    if (path.endsWith('.gz')) {
      res.set('Content-Encoding', 'gzip');
    }
  }
}));

app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});


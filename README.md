# Getting Started

集成demo，都是独立模块

### Reference Documentation

* [规则计算引擎drools](https://github.com/thinban/springboot-demos/tree/main/drools)
* [mybatisplus](https://github.com/thinban/springboot-demos/tree/main/mybatisplus)

### 拷贝部分目录

```shell
# 举例仅拷贝 mybatisplus
mkdir mybatisplus &&
git init &&
git remote add origin https://github.com/thinban/springboot-demos.git &&
git config core.sparsecheckout true &&
echo "mybatisplus" >> .git/info/sparse-checkout &&
git pull --depth 1 origin main
```
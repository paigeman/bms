#!/bin/bash

# 获取传递的进程名称或关键字作为命令行参数
process_name="$1"

if [ -z "$process_name" ]; then
  echo "请输入要查找的进程名称或关键字。"
  exit 1
fi

# 使用 ps 命令结合 grep 过滤进程并获取进程的 PID
pid=$(ps aux | grep "$process_name" | grep -v grep | awk '{print $2}')

if [ -n "$pid" ]; then
  # 找到进程的 PID，发送终止信号给进程
  kill "$pid"
  echo "进程 $pid 已关闭。"
else
  echo "未找到进程 $process_name。"
fi
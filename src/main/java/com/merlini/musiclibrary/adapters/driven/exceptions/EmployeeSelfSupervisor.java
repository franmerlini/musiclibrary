package com.merlini.musiclibrary.adapters.driven.exceptions;

public class EmployeeSelfSupervisor extends RuntimeException {
  public EmployeeSelfSupervisor() {
    super("Employee cannot be its own supervisor.");
  }
}

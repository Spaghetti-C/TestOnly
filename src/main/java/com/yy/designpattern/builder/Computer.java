package com.yy.designpattern.builder;

/**
 * Description:
 *
 * @author chenyiqin02
 * @date 2022/03/17
 */
public class Computer {
    private String cpu;
    private String gpu;
    private String ram;
    private String hardDisk;

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", ram='" + ram + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                '}';
    }

    private Computer(Computer.Builder builder) {
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.ram = builder.ram;
        this.hardDisk = builder.hardDisk;
    }

    public static Computer.Builder builder() {
        return new Computer.Builder();
    }

    public static class Builder {
        private String cpu;
        private String gpu;
        private String ram;
        private String hardDisk;

        public Computer.Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Computer.Builder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Computer.Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Computer.Builder setHardDisk(String hardDisk) {
            this.hardDisk = hardDisk;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

}

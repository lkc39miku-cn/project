package org.example.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class IpUtils {
    public static String getIpAddress(HttpServletRequest request) {
        if (Objects.isNull(request)) {
            return "unknown";
        }

        String ip = request.getHeader("x-forwarded-for");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : getMultistageReverseProxyIp(ip);
    }

    public static String getMultistageReverseProxyIp(String ip) {
        if (Objects.nonNull(ip) && ip.indexOf(',') > 0) {
            String[] ips = ip.trim().split(",");
            for (String subIp : ips) {
                if (Boolean.FALSE.equals(isUnknown(subIp))) {
                    ip = subIp;
                    break;
                }
            }
        }
        return ip;
    }

    public static Boolean isUnknown(String checkString) {
        return StringUtils.isEmpty(checkString) || "unknown".equalsIgnoreCase(checkString);
    }

    public static Boolean isHttp(String path) {
        return StringUtils.startsWithAny(path, "http://", "https://");
    }

    public static Boolean internalIp(String ip) {
        Byte[] address = textToNumericFormatV4(ip);
        return internalIp(address) || "127.0.0.1".equals(ip);
    }

    private static Boolean internalIp(Byte[] address) {
        if (Objects.isNull(address) || address.length < 1) {
            return true;
        }

        final byte b0 = address[0];
        final byte b1 = address[1];
        final byte one = 0x0A;
        final byte two = (byte) 0xAC;
        final byte three = (byte) 0x10;
        final byte four = (byte) 0x1F;
        final byte five = (byte) 0xC0;
        final byte six = (byte) 0xA8;

        switch (b0) {
            case one:
                return true;
            case two:
                if (b1 >= three && b1 <= four) {
                    return true;
                }
                break;
            case five:
                if (b1 == six) {
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    public static Byte[] textToNumericFormatV4(String text) {
        if (StringUtils.isEmpty(text)) {
            return new Byte[]{};
        }

        Byte[] bytes = new Byte[4];
        String[] elements = text.split("\\.", -1);

        try {
            long l;
            int i;
            switch (elements.length) {
                case 1:
                    l = Long.parseLong(elements[0]);

                    if ((l < 0L) || (l > 4294967295L)) {
                        return new Byte[]{};
                    }

                    bytes[0] = (byte) (int) (l >> 24 & 0xFF);
                    bytes[1] = (byte) (int) ((l & 0xFFFFFF) >> 16 & 0xFF);
                    bytes[2] = (byte) (int) ((l & 0xFFFF) >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 2:
                    l = Integer.parseInt(elements[0]);

                    if ((l < 0L) || (l > 255L)) {
                        return new Byte[]{};
                    }

                    bytes[0] = (byte) (int) (l & 0xFF);
                    l = Integer.parseInt(elements[1]);
                    if ((l < 0L) || (l > 16777215L)) {
                        return new Byte[]{};
                    }

                    bytes[1] = (byte) (int) (l >> 16 & 0xFF);
                    bytes[2] = (byte) (int) ((l & 0xFFFF) >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 3:
                    for (i = 0; i < 2; ++i) {
                        l = Integer.parseInt(elements[i]);

                        if ((l < 0L) || (l > 255L)) {
                            return new Byte[]{};
                        }
                        bytes[i] = (byte) (int) (l & 0xFF);
                    }

                    l = Integer.parseInt(elements[2]);
                    if ((l < 0L) || (l > 65535L)) {
                        return new Byte[]{};
                    }

                    bytes[2] = (byte) (int) (l >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 4:
                    for (i = 0; i < 4; ++i) {
                        l = Integer.parseInt(elements[i]);

                        if ((l < 0L) || (l > 255L)) {
                            return new Byte[]{};
                        }
                        bytes[i] = (byte) (int) (l & 0xFF);
                    }
                    break;
                default:
                    return new Byte[]{};
            }
        } catch (NumberFormatException e) {
            return new Byte[]{};
        }
        return bytes;
    }
}
DESCRIPTION = "Library for parsing CORBA IDL files"
SECTION = "libs"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=55ca817ccb7d5b5b66355690e9abc605"

inherit autotools pkgconfig

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/libIDL/0.8/libIDL-${PV}.tar.bz2"

S = "${WORKDIR}/libIDL-${PV}"

FILES_${PN} = "${libdir}/*.so.*"
FILES_${PN}-dev += " ${bindir}"

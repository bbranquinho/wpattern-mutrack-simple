package org.wpattern.mutrack.simple.packagee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.mutrack.simple.utils.GenericService;
import org.wpattern.mutrack.simple.utils.ServiceNames;

@RestController
@RequestMapping(path = ServiceNames.PACKAGE_PATH)
public class PackageService extends GenericService<PackageEntity, Long> {

}

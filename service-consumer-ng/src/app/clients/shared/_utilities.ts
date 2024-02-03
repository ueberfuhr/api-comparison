export function idFromDomainObject<DomainObjectType, IdType>(
  domainObject: DomainObjectType | IdType,
  domainObjectIsIdFn: (domainObject: DomainObjectType | IdType) => boolean,
  idFn: (domainObject: DomainObjectType) => IdType | null | undefined
): IdType | undefined {
  if (domainObjectIsIdFn(domainObject)) {
    return domainObject as IdType;
  } else {
    const id = idFn(domainObject as DomainObjectType);
    if (!id) {
      throw new Error('The given todo does not have any id.')
    }
    return id;
  }
}
